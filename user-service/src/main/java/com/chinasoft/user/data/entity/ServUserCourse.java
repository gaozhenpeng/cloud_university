package com.chinasoft.user.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@Entity
public class ServUserCourse implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**课程ID**/
    public Long courseId;
    /**课程名称**/
    public String courseName;
    /**用户ID**/
    public Long servUserId;
    /**选课时间**/
    public java.util.Date createTime;
    /**学习时长**/
    public Long learnLength;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
