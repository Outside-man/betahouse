package com.betahouse.serviceuser.app.core.user.validate;

import com.betahouse.serviceuser.app.core.user.model.UserBO;
import exceptions.BetahouseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utils.AssertUtil;
import utils.TestAssertUtil;

/**
 * 用户名基础验证器测试实例
 *
 * @author dango.yxm
 * @version : UserNameBasicValidatorTest.java 2018/10/05 下午11:14 dango.yxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserNameBasicValidatorTest {

    @Autowired
    private UserNameBasicValidator userNameBasicValidator;

    @Test
    public void support() {
        AssertUtil.assertTrue(userNameBasicValidator.support(new UserBO()));
    }

    @Test
    public void validate() {
        // 实体为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            userNameBasicValidator.validate(null);
        });

        // 账号为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            userNameBasicValidator.validate(user);
        });

        // 账号有特殊字符
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            user.setUsername("☺");
            userNameBasicValidator.validate(user);
        });

        // 账号正常
        UserBO user = new UserBO();
        user.setUsername("ssasasa");
        userNameBasicValidator.validate(user);
    }
}