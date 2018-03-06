package com.chinasoft.gateway.vo;

/**
 * Created by VerRan.Liu on 2017/10/25.
 */
public class TokenRepVO implements java.io.Serializable {
    private String token;
    private String code;//返回编码
    private String message;//返回编码描述

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
