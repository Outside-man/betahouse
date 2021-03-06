/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.core.user.manager;


import com.betahouse.serviceuser.app.core.user.model.UserBO;

/**
 * 用户查询管理
 * @author dango.yxm
 * @version : UserQueryManager.java 2018/10/06 上午12:14 dango.yxm
 */
public interface UserQueryManager {

    /**
     * 通过账号获取用户
     * @param username
     * @return
     */
    UserBO queryByUsername(String username);
}
