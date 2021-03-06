/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.core.user.manager.impl;

import com.betahouse.serviceuser.app.common.dao.service.UserService;
import com.betahouse.serviceuser.app.core.user.manager.UserManager;
import com.betahouse.serviceuser.app.core.user.model.UserBO;
import model.request.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private MultiValidator<UserBO> userRegisterValidator;

    @Override
    public UserBO register(UserRegisterRequest registerRequest) {
        // 组装领域模型
        UserBO userBO = new UserBO();
        userBO.setUsername(registerRequest.getUsername());
        userBO.setPassword(registerRequest.getPassword());
        // 验证实体
        userRegisterValidator.validate(userBO);
        // 插入实体
        userBO.setSalt("1");
        return userService.insertUser(userBO);
    }
}
