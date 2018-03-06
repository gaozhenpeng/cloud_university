package com.chinasoft.gateway.vo;

/**
 * Created by VerRan.Liu on 2017/10/25.
 */
public class TokenReqVO implements java.io.Serializable {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
