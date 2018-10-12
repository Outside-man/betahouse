/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.core.gateway.validate;

import com.betahouse.serviceuser.app.common.dao.model.UserDO;
import com.betahouse.serviceuser.app.common.dao.repo.UserRepo;
import model.request.UserRegisterRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
