/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.manager.impl;

import com.betahouse.servicezuul.app.core.gateway.dao.service.UserService;
import com.betahouse.servicezuul.app.core.gateway.manager.UserManager;
import com.betahouse.servicezuul.app.core.gateway.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.request.UserRegisterRequest;
import validator.MultiValidator;

/**
 * 用户管理实现
 * @author dango.yxm
 * @version : UserManagerImpl.java 2018/10/06 上午12:02 dango.yxm
 */
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserService userService;

    @Autowired
    private MultiValidator userRegisterValidator;

    @Override
    public UserBO register(UserRegisterRequest registerRequest) {
        // 请求校验
        userRegisterValidator.validate(registerRequest);
        // 插入实体
        UserBO userBO = new UserBO();
        userBO.setUsername(registerRequest.getUsername());
        userBO.setPassword(registerRequest.getPassword());
        userBO.setSalt("1");
        return userService.insertUser(userBO);
    }
}
