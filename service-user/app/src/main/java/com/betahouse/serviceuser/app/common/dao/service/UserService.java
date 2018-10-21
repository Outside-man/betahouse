/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.common.dao.service;


import com.betahouse.serviceuser.app.core.user.model.UserBO;

/**
 * 用户服务
 *
 * @author dango.yxm
 * @version : UserService.java 2018/10/06 上午12:05 dango.yxm
 */
public interface UserService {

    /**
     * 获取用户 by 用户名
     *
     * @param username
     * @return
     */
    UserBO queryByUsername(String username);

    /**
     * 插入用户信息
     * @param userBO
     * @return
     */
    UserBO insertUser(UserBO userBO);
}
