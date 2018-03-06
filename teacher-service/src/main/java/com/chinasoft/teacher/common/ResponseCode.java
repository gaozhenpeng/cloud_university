package com.chinasoft.teacher.common;

/**
 * Created by zhangyan
 */
public enum ResponseCode {

    SUCCESS(1,"SUCCESS"),
    ERROR(2,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(3,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String message;


    ResponseCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

}
