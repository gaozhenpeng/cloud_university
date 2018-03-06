package com.chinasoft.user.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by VerRan.Liu on 2017/9/20.
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class RequestVO<T> implements Serializable {
    private String token;//服务请求的令牌
    private String version;//请求协议的版本信息预留
//    private String source;//请求来源，如果请求来源与portal ，token不进行过期处理
    private String serviceCode;//服务编码，用于标识服务的唯一性0
    private T input;

//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }
}
