/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.dao.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户账户
 * @author dango.yxm
 * @version : UserDO.java 2018/10/05 上午10:46 dango.yxm
 */
@Entity
@Table(name = "common_user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1660907732049201911L;

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Column(name = "gmt_create")
    private Long gmtCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    private Long gmtModified;

    /**
     * userId 生成 不可修改
     */
    @Column(name = "user_id", updatable = false)
    private String userId;

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 密码 长度不超过32位
     */
    @Column(length = 32)
    private String password;

    /**
     * 盐
     */
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
