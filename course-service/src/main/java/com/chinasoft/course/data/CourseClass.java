package com.chinasoft.course.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by VerRan.Liu on 2017/11/14.
 */
@Entity
public class CourseClass implements java.io.Serializable {

    /** 课程分类ID **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 课程分类名称 **/
    private String className ;
    /** 课程分类编码 **/
    private String classCode;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
}
