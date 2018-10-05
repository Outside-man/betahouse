/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.core.gateway.dao.service.impl;

import com.betahouse.servicezuul.core.gateway.dao.model.UserDO;
import com.betahouse.servicezuul.core.gateway.dao.repo.UserRepo;
import com.betahouse.servicezuul.core.gateway.dao.service.UserService;
import com.betahouse.servicezuul.core.gateway.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.AssertUtil;

/**
 * 用户服务实现
 *
 * @author dango.yxm
 * @version : UserServiceImpl.java 2018/10/06 上午12:09 dango.yxm
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserBO queryByUsername(String username) {
        return covert(userRepo.getByUsername(username));
    }

    @Override
    public UserBO insertUser(UserBO userBO) {
        UserDO userDO = covert(userBO);
        AssertUtil.assertNotNull(userDO, "不能存储空用户实体");
        userRepo.save(userDO);
        return covert(userDO);
    }

    /**
     * 转换器 UserDO2UserBO
     *
     * @param userDO
     * @return
     */
    private UserBO covert(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        userBO.setUsername(userDO.getUsername());
        userBO.setPassword(userDO.getPassword());
        userBO.setSalt(userDO.getSalt());
        return userBO;
    }

    /**
     * 转换器 UserBO2UserDO
     *
     * @param userBO
     * @return
     */
    private UserDO covert(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(userBO.getUsername());
        userDO.setPassword(userBO.getPassword());
        userDO.setSalt(userBO.getSalt());
        return userDO;
    }
}
