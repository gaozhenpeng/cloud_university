package com.chinasoft.system.vo;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
public class Domain implements java.io.Serializable{
    private String name ;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Domain() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
