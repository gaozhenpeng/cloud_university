package com.chinasoft.system.vo;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
public class SmsVO implements java.io.Serializable{
    private String endpoint;
    private String message;
//    private String sign_id;

    public SmsVO() {
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getSign_id() {
//        return sign_id;
//    }
//
//    public void setSign_id(String sign_id) {
//        this.sign_id = sign_id;
//    }
}
