package com.chinasoft.gateway.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by VerRan.Liu on 2017/9/20.
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class RequestVO<T> implements Serializable {
    private String token;//服务请求的令牌
    /**V2 版本增加path方式访问 **/
    private String path;
    private T input;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getInput() {
        return input;
    }

    public void setInput(T input) {
        this.input = input;
    }
}
