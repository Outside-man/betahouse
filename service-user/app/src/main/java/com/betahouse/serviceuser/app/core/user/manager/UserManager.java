/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.core.user.manager;

import com.betahouse.serviceuser.app.core.user.model.UserBO;
import model.request.UserRegisterRequest;

/**
 * 用户管理器
 *
 * @author dango.yxm
 * @version : UserManager.java 2018/10/06 上午12:01 dango.yxm
 */
public interface UserManager {

    /**
     * 注册账号
     *
     * @param registerRequest
     * @return
     */
    UserBO register(UserRegisterRequest registerRequest);
}
