/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.core.user.validate;

import com.betahouse.serviceuser.app.common.dao.model.UserDO;
import com.betahouse.serviceuser.app.common.dao.repo.UserRepo;
import com.betahouse.serviceuser.app.core.user.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import utils.AssertUtil;
import utils.CharsetEncodingUtil;
import validator.Validator;

/**
 * 用户名基础校验器
 *
 * @author dango.yxm
 * @version : UserNameBasicValidator.java 2018/10/05 下午11:14 dango.yxm
 */
public class UserNameBasicValidator implements Validator<UserBO> {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean support(UserBO user) {
        return true;
    }

    @Override
    public void validate(UserBO user) {
        AssertUtil.assertNotNull(user, "请求不能为空");
        AssertUtil.assertStringNotBlank(user.getUsername(), "用户名不能为空");
        AssertUtil.assertTrue(CharsetEncodingUtil.canEncodeGBK(user.getUsername()), "用户名不能包含特殊字符");
        UserDO userDO = userRepo.getByUsername(user.getUsername());
        AssertUtil.assertNull(userDO, "用户名已经注册");
    }
}
