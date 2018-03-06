package com.chinasoft.user.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@Entity
public class CourseComment implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**用户ID**/
    public Long servUserId;
    /**课程ID**/
    public int courseId;
    /**课程名称**/
    public String courseName;
    /**评论时间**/
    public String createTime;
    /**评论信息**/
    public String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
