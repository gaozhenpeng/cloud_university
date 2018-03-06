package com.chinasoft.system.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  create by cuierqiang
 */
@Component
@ConfigurationProperties
@PropertySource("classpath:systemMSG.properties")
public class SystemConfiguration {
    /**不能为空*/
    private String notnull;

    /**成功*/
    private String successMSG;

    /**失败*/
    private String failMSG;

    /**登录成功*/
    private String loginSuccess;

    /**登录失败*/
    private String loginFail;

    /**注册成功*/
    private String registerSuccess;

    /**注册失败*/
    private String registerFail;

    public String getNotnull() {
        return notnull;
    }

    public void setNotnull(String notnull) {
        this.notnull = notnull;
    }

    public String getSuccessMSG() {
        return successMSG;
    }

    public void setSuccessMSG(String successMSG) {
        this.successMSG = successMSG;
    }

    public String getFailMSG() {
        return failMSG;
    }

    public void setFailMSG(String failMSG) {
        this.failMSG = failMSG;
    }

    public String getLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(String loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getLoginFail() {
        return loginFail;
    }

    public void setLoginFail(String loginFail) {
        this.loginFail = loginFail;
    }

    public String getRegisterSuccess() {
        return registerSuccess;
    }

    public void setRegisterSuccess(String registerSuccess) {
        this.registerSuccess = registerSuccess;
    }

    public String getRegisterFail() {
        return registerFail;
    }

    public void setRegisterFail(String registerFail) {
        this.registerFail = registerFail;
    }
}
