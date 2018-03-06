package com.chinasoft.system.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by zhangyan
 */

//保证序列化json的时候,如果是null的对象,key也会消失
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private String token;
    private int code;
    private String message;
    private T output;

    private ServerResponse(int code){
        this.code = code;
    }
    private ServerResponse(int code,T output){
        this.code = code;
        this.output = output;
    }

    private ServerResponse(int code, String message, T output){
        this.code = code;
        this.message = message;
        this.output = output;
    }

    private ServerResponse(int code,String message){
        this.code = code;
        this.message = message;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode(){
        return code;
    }
    public T getOutput(){
        return output;
    }
    public String getMessage(){
        return message;
    }
    public String getToken() {
        return token;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> ServerResponse<T> createBySuccess(T output){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),output);
    }

    public static <T> ServerResponse<T> createBySuccess(String message, T output){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),message,output);
    }


    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}
