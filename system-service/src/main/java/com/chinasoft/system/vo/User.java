package com.chinasoft.system.vo;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements java.io.Serializable {
    private String name;
    private String password;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Domain domain;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}

