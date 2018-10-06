/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.dao.service.impl;

import com.betahouse.servicezuul.app.core.gateway.dao.model.UserDO;
import com.betahouse.servicezuul.app.core.gateway.dao.repo.UserRepo;
import com.betahouse.servicezuul.app.core.gateway.dao.service.UserService;
import com.betahouse.servicezuul.app.core.gateway.model.UserBO;
import com.betahouse.servicezuul.app.core.gateway.util.UserConverter;
import com.betahouse.servicezuul.app.core.idfactory.BizIdFactory;
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

    @Autowired
    private BizIdFactory bizIdFactory;

    @Override
    public UserBO queryByUsername(String username) {
        return covert(userRepo.getByUsername(username));
    }

    @Override
    public UserBO insertUser(UserBO userBO) {
        UserDO userDO = covert(userBO);
        userDO.setUserId(bizIdFactory.getUserId());
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
        return UserConverter.DO2BO(userDO);
    }

    /**
     * 转换器 UserBO2UserDO
     *
     * @param userBO
     * @return
     */
    private UserDO covert(UserBO userBO) {
        return UserConverter.BO2DO(userBO);
    }
}
