package com.chinasoft.obs.vo;

/**
 * Created by VerRan.Liu on 2017/9/28.
 */
public class DelVO implements java.io.Serializable {
    private String id;//用于删除记录的id，支持删除多个 用逗号分隔

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
