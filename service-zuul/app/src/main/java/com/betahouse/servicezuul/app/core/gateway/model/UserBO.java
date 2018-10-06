/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.model;

import com.betahouse.servicezuul.app.common.service.facade.src.main.java.common.ToString;

/**
 * 用户领域模型
 *
 * @author dango.yxm
 * @version : UserBO.java 2018/10/06 上午12:05 dango.yxm
 */
public class UserBO extends ToString {

    private static final long serialVersionUID = 1747727186331072029L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

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
