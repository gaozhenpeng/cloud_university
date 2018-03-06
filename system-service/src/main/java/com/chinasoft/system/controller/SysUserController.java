package com.chinasoft.system.controller;


import com.chinasoft.system.data.entity.User;
import com.chinasoft.system.data.model.UserQo;
import com.chinasoft.system.service.SysUserService;
import com.chinasoft.system.vo.ServerResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by cuierqiang.
 */
@RestController
@RequestMapping(value = "/user")
//通过CrossOrigin支持跨域访问
@CrossOrigin
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value="注册", notes="提供给门户系统用于实现注册，该接口允许跨域访问")
    @ApiImplicitParam(name = "user", value = "用户信息的json", required = true, dataType = "UserQo")
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ServerResponse<User> register(@RequestBody UserQo UserQo){
        ServerResponse<User> response = sysUserService.register(UserQo);
        return response;
    }

    @ApiOperation(value="登录", notes="根据url的loginName, password来获取用户详细信息")
    @ApiImplicitParam(name = "user", value = "用户信息的json", required = true, dataType = "UserQo")
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ServerResponse<User> login(@RequestBody User user, HttpSession session) {
        ServerResponse<User> response = sysUserService.login(user,session);
        return response;
    }

    @ApiOperation(value="密码找回", notes="用户找回密码")
    @ApiImplicitParam(name = "user", required = true, dataType = "UserQo")
        @RequestMapping(value="/forgetPassword", method=RequestMethod.POST)
    public ServerResponse<User> forgetPassword(@RequestBody UserQo user) {
        ServerResponse<User> response = sysUserService.forgetPassword(user);
        return response;
    }

    @ApiOperation(value="注销", notes="用户前进后退回跳出当前登录的账户")
    @ApiImplicitParam(name = "user", required = true, dataType = "User")
    @RequestMapping(value="/logout", method=RequestMethod.POST)
    public String logout(@ModelAttribute("User") User user, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "login";
    }

    @ApiOperation(value="密码找回校验", notes="用户找回密码校验")
    @ApiImplicitParam(name = "user", required = true, dataType = "UserQo")
    @RequestMapping(value="/vercodeCheck", method=RequestMethod.POST)
    public ServerResponse vercodeCheck(@RequestBody UserQo user) {
        ServerResponse response = sysUserService.vercodeCheck(user);
        return response;
    }
}
