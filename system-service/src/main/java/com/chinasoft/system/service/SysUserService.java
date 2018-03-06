package com.chinasoft.system.service;

import com.chinasoft.system.data.entity.User;
import com.chinasoft.system.data.entity.VerCode;
import com.chinasoft.system.data.model.UserQo;
import com.chinasoft.system.data.repository.RoleRepository;
import com.chinasoft.system.data.repository.UserRepository;
import com.chinasoft.system.data.repository.VerCodeRepository;
import com.chinasoft.system.vo.ServerResponse;
import com.chinasoft.system.vo.SystemConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cuierqiang.
 */
@Service
public class SysUserService {
    private static Logger logger = LoggerFactory.getLogger(SysUserService.class);

    public final static long FIFTEEN_Minute =15*60*1000;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    VerCodeRepository verCodeRepository;
    @Autowired
    UserRepository sysUserRepository;
    @Autowired
    SystemConfiguration systemConfiguration;

    private  static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    boolean flag = false;

    MessageDigest md5 = null;



    /**
     * 注册
     * @param user
     * @return
     */
    public ServerResponse<User> register(UserQo user) {
        User loginNameGet = sysUserRepository.findByLoginName(user.getLoginName());
        User mobiLePhoneGet = sysUserRepository.findByMobilePhone(user.getMobilePhone());
        if (user.getLoginName() == null) {
            return ServerResponse.createByErrorMessage("用户名为空");
        }
        if (loginNameGet != null) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        if (mobiLePhoneGet != null) {
            return ServerResponse.createByErrorMessage("手机号已存在");
        }

        if (user.getPassword() == null) {
            return ServerResponse.createByErrorMessage("密码为空");
        }
        if (user.getMobilePhone() == null) {
            return ServerResponse.createByErrorMessage("手机号为空");
        }
        VerCode verCode = new VerCode();
        verCode.setEndpoint(user.getMobilePhone());
        verCode.setType("R");
        verCode.setVercode(user.getVercode());
        boolean loginFlag = checkVerCode(verCode);
        if (!loginFlag) {
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            String pwd = base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
            user.setPassword(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.flag) {
            User userTemp = new User();
            userTemp.setLoginName(user.getLoginName());
            userTemp.setPassword(user.getPassword());
            userTemp.setMobilePhone(user.getMobilePhone());
            userTemp.setRole("visitor");
            User userGet = sysUserRepository.saveAndFlush(userTemp);
            if (userGet != null) {
                return ServerResponse.createBySuccess(systemConfiguration.getSuccessMSG(), userGet);
            } else return ServerResponse.createByErrorMessage(systemConfiguration.getFailMSG());
        }
        return ServerResponse.createByErrorMessage(systemConfiguration.getNotnull());
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public ServerResponse<User> login(User user,HttpSession session) {
        // 密码为空判断
        if (user.getPassword() == null) {
            return ServerResponse.createByErrorMessage("密码为空");
        }

        // 用户名是否存在判断
        User userGet = sysUserRepository.findByLoginNameOrMobilePhone(user.getLoginName(), user.getLoginName());
        if (userGet == null) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        // 密码正确判断
        String pwd = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            pwd = base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 登陆次数限制功能
        int count = userGet.getCount();
        if (count >= 3) {
            try {
                long sysdate = sdf.parse(sdf.format(new Date())).getTime();
                long errordate = sdf.parse(userGet.getErrordate()).getTime();
                if (sysdate - errordate < FIFTEEN_Minute) {
                    return ServerResponse.createByErrorMessage("该账户锁定时间未到15分钟");
                } else {
                    if (userGet.getPassword().equals(pwd)) {
                        userGet.setCount(0);
                        sysUserRepository.saveAndFlush(userGet);
                        userGet.setPassword("");
                        return ServerResponse.createBySuccess("登录成功", userGet);
                    } else {
                        count++;
                        if (count % 3 == 0) {
                            userGet.setErrordate(sdf.format(new Date()));
                            userGet.setCount(count);
                            sysUserRepository.saveAndFlush(userGet);
                            return ServerResponse.createByErrorMessage("密码错误3次，账户锁定");
                        } else {
                            userGet.setCount(count);
                            sysUserRepository.saveAndFlush(userGet);
                            return ServerResponse.createByErrorMessage("账号或密码错误，如果再错误"+(3-count%3)+"次将会被锁定十五分钟！");
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            if (userGet.getPassword().equals(pwd)) {
                userGet.setCount(0);
                sysUserRepository.saveAndFlush(userGet);
                userGet.setPassword("");
                return ServerResponse.createBySuccess("登录成功", userGet);
            } else {
                count++;
                if (count > 0 && count % 3 == 0) {
                    userGet.setErrordate(sdf.format(new Date()));
                    userGet.setCount(count);
                    sysUserRepository.saveAndFlush(userGet);
                    return ServerResponse.createByErrorMessage("密码错误3次，账户锁定");
                }
                userGet.setCount(count);
                sysUserRepository.saveAndFlush(userGet);
                return ServerResponse.createByErrorMessage("账号或密码错误，如果再错误"+(3-count%3)+"次将会被锁定十五分钟！");
            }
        }
        return ServerResponse.createByError();
    }

    /**
     * 验证码验证
     * @param verCode
     * @return
     */
    public boolean checkVerCode(VerCode verCode){
        VerCode verCodeget=verCodeRepository.findvercodeByEndpointAndCreatedateAndType(verCode.getEndpoint(),verCode.getType());
        if (verCodeget != null && verCode.getVercode().equals(verCodeget.getVercode())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改密码
     * @param verCode
     * @return
     */
    /*
    public ServerResponse<User> changePassword(User user){
        VerCode verCode = new VerCode();
        verCode.setEndpoint(user.getMobilePhone());
        verCode.setVercode(user.getVercode());
        User passwordGet=sysUserRepository.findByMobilePhone(verCode.getEndpoint());
        String pwd=null;
        String userPasswordGet=user.getPassword();
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            pwd = base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (passwordGet != null) {
            if (passwordGet.getPassword().equals(pwd)) {
                logger.info("");
            }

        }
        return ServerResponse.createByErrorMessage("修改失败");
    }*/

    /**
     * 忘记密码找回密码
     * @param user
     * @return
     */
    public ServerResponse<User> forgetPassword(UserQo user) {
        VerCode verCode = new VerCode();
        verCode.setEndpoint(user.getMobilePhone());
        verCode.setType("F");
        verCode.setVercode(user.getVercode());
        boolean loginFlag = checkVerCode(verCode);
        if (!loginFlag) {
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        if (user.getPassword() == null) {
            return ServerResponse.createByErrorMessage("新密码为空");
        }
        String pwd=null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            pwd = base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User passwordGet=sysUserRepository.findByMobilePhone(verCode.getEndpoint());
        if (passwordGet != null) {
            if (passwordGet.getPassword().equals(pwd)) {
                return ServerResponse.createByErrorMessage("密码未改变，请重新输入");
            }else {
                passwordGet.setPassword(pwd);
                User newUser = sysUserRepository.saveAndFlush(passwordGet);
                return ServerResponse.createBySuccess("修改成功", newUser);
            }
        }
        return ServerResponse.createByErrorMessage(systemConfiguration.getNotnull());
    }

    /**
     * 忘记密码找回密码校验
     * @param user
     * @return
     */
    public ServerResponse vercodeCheck(UserQo user) {
        // 验证手机号是否注册
        User userTemp = sysUserRepository.findByMobilePhone(user.getMobilePhone());
        if (userTemp == null) {
            return ServerResponse.createByErrorMessage("该手机号未注册");
        }
        VerCode verCode = new VerCode();
        verCode.setEndpoint(user.getMobilePhone());
        verCode.setType("F");
        verCode.setVercode(user.getVercode());
        boolean loginFlag = checkVerCode(verCode);
        if (!loginFlag) {
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        // 把用户名返回前端
        User user1 = new User();
        user1.setLoginName(userTemp.getLoginName());
        return ServerResponse.createBySuccess(user1);
    }



}


