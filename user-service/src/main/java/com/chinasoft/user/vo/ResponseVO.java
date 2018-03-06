package com.chinasoft.user.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by VerRan.Liu on 2017/9/20.
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ResponseVO<T> implements java.io.Serializable{
    private String token;
    private String code;//返回编码
    private String message;//返回编码描述
    private T output;//输出信息 使用泛型

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

    public T getOutput() {
        return output;
    }

    public void setOutput(T output) {
        this.output = output;
    }
}
