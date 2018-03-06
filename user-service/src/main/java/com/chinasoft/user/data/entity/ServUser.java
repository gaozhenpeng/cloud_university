package com.chinasoft.user.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@Entity
public class ServUser implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**昵称**/
    public String name;
    /**年龄**/
    public String age;
    /**职业**/
    public String vocation;
    /**居住地址**/
    public String address;
    /**性别**/
    public String sex;
    /**性别**/
    public String mobile;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
