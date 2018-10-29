/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.common.dao.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户账户
 *
 * @author dango.yxm
 * @version : UserDO.java 2018/10/05 上午10:46 dango.yxm
 */
@Entity
@Table(name = "common_user")
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name = "user_id", updatable = false, unique = true)
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

    /**
     * 上次登录时间
     */
    @Column(length = 20)
    private Long lastLoginDate;

    /**
     * 上次登录ip
     */
    @Column(length = 32)
    private String lastLoginIP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }
}
