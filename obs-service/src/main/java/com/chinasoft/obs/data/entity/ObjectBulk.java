package com.chinasoft.obs.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by VerRan.Liu on 2017/11/16.
 */
@Entity
public class ObjectBulk implements java.io.Serializable{
    /** 主键 **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 对象名称，如存储课件时存储课件名称 **/
    private String objectName;
    /** 创建时间 **/
    private String creteDate;
    /** 对象所有者 **/
    private String owner;
    /** 对象路径 **/
    private String url;

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getCreteDate() {
        return creteDate;
    }

    public void setCreteDate(String creteDate) {
        this.creteDate = creteDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
