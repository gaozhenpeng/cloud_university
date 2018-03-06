package com.chinasoft.system.data.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class UserQo extends PageQo{
    /**用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**用户名*/
    private String loginName;

    /**密码*/
    private String password;

    /**真实姓名*/
    private String name;

    /**邮箱*/
    private String email;

    /**年龄*/
    private String age;

    /**手机号码*/
    private String mobilePhone;

    /**登录错误次数*/
    private int count;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /**三次错误密码登陆失败后的时间*/
    private Date errordate;

    /**验证码*/
    private String vercode;

    /**状态*/
    private String status;

    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdate;

    /**验证码类型*/
    private String type;

    /**登录时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String logindate;



    public UserQo() {
    }



    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getErrordate() {
        return errordate;
    }

    public void setErrordate(Date errordate) {
        this.errordate = errordate;
    }
}
