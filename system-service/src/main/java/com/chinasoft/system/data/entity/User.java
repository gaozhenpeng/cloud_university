package com.chinasoft.system.data.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable{
    /**用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    /**用户名*/
    @Column(name="login_Name")
    private String loginName;

    /**密码*/
    @Column(name = "password")
    private String password;

    /**真实姓名*/
    @Column(name = "name")
    private String name;

    /**邮箱*/
    @Column(name = "email")
    private String email;

    /**年龄*/
    @Column(name = "age")
    private String age;

    /**手机号码*/
    @Column(name = "mobile_Phone")
    private String mobilePhone;

    /**登录错误次数*/
    @Column(name = "count")
    private int count;

    /**三次错误密码登陆失败后的时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "errordate")
    private String errordate;

    /**状态*/
    @Column(name = "status")
    private String status;

    /**角色*/
    @Column(name = "role")
    private String role;

    /**创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "createdate")
    private String createdate;

    /**登录时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "logindate")
    private String logindate;

    public User() {
    }


    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getErrordate() {
        return errordate;
    }

    public void setErrordate(String errordate) {
        this.errordate = errordate;
    }
}
