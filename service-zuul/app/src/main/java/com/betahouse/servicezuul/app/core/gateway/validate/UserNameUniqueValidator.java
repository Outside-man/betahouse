/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.validate;

import com.betahouse.servicezuul.app.core.gateway.dao.model.UserDO;
import com.betahouse.servicezuul.app.core.gateway.dao.repo.UserRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import model.request.UserRegisterRequest;
import utils.AssertUtil;
import validator.Validator;

/**
 * 用户名唯一校验器
 *
 * @author dango.yxm
 * @version : UserNameUniqueValidator.java 2018/10/05 下午11:14 dango.yxm
 */
public class UserNameUniqueValidator implements Validator<UserRegisterRequest> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean support(UserRegisterRequest request) {
        return request != null && StringUtils.isNotBlank(request.getUsername());
    }

    @Override
    public void validate(UserRegisterRequest request) {
        UserDO user = userRepo.getByUsername(request.getUsername());
        AssertUtil.assertNull(user, "账户已经注册");
    }
}
