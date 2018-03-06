package com.chinasoft.obs.vo;

/**
 * Created by VerRan.Liu on 2017/11/16.
 */
public class ObjectBulkVO extends PageVO {
    /** 对象名称 ，这里可以是课件名称 **/
    private String objectName ;
    /** 对象所有者， 如根据上传课件的人来查询 **/
    private String owner;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
