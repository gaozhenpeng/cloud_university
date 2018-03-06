package com.chinasoft.teacher.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Honkey on 2017/11/16 15:09.
 */
@Component
@ConfigurationProperties
@PropertySource("classpath:teacherMsg.properties")
public class MessageConfig {

    private String notNull;
    private String teaIdNoExist;
    private String addTeaSuccess;
    private String addTeaFail;
    private String updateTeaSuccess;
    private String updateTeaFail;
    private String findTeaSuccess;
    private String findTeaFail;
    private String deleteTeaSuccess;
    private String deleteTeaFail;

    public MessageConfig() {
    }

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public String getTeaIdNoExist() {
        return teaIdNoExist;
    }

    public void setTeaIdNoExist(String teaIdNoExist) {
        this.teaIdNoExist = teaIdNoExist;
    }

    public String getAddTeaSuccess() {
        return addTeaSuccess;
    }

    public void setAddTeaSuccess(String addTeaSuccess) {
        this.addTeaSuccess = addTeaSuccess;
    }

    public String getAddTeaFail() {
        return addTeaFail;
    }

    public void setAddTeaFail(String addTeaFail) {
        this.addTeaFail = addTeaFail;
    }

    public String getUpdateTeaSuccess() {
        return updateTeaSuccess;
    }

    public void setUpdateTeaSuccess(String updateTeaSuccess) {
        this.updateTeaSuccess = updateTeaSuccess;
    }

    public String getUpdateTeaFail() {
        return updateTeaFail;
    }

    public void setUpdateTeaFail(String updateTeaFail) {
        this.updateTeaFail = updateTeaFail;
    }

    public String getFindTeaSuccess() {
        return findTeaSuccess;
    }

    public void setFindTeaSuccess(String findTeaSuccess) {
        this.findTeaSuccess = findTeaSuccess;
    }

    public String getFindTeaFail() {
        return findTeaFail;
    }

    public void setFindTeaFail(String findTeaFail) {
        this.findTeaFail = findTeaFail;
    }

    public String getDeleteTeaSuccess() {
        return deleteTeaSuccess;
    }

    public void setDeleteTeaSuccess(String deleteTeaSuccess) {
        this.deleteTeaSuccess = deleteTeaSuccess;
    }

    public String getDeleteTeaFail() {
        return deleteTeaFail;
    }

    public void setDeleteTeaFail(String deleteTeaFail) {
        this.deleteTeaFail = deleteTeaFail;
    }
}
