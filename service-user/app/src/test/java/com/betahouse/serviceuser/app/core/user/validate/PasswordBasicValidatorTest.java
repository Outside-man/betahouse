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
 * 密码基础验证器测试实例
 *
 * @author dango.yxm
 * @version : PasswordBasicValidatorTest.java 2018/10/05 下午11:14 dango.yxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordBasicValidatorTest {

    @Autowired
    private PasswordBasicValidator passwordBasicValidator;

    @Test
    public void support() {
        AssertUtil.assertTrue(passwordBasicValidator.support(new UserBO()));
    }

    @Test
    public void validate() {
        // 实体为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            passwordBasicValidator.validate(null);
        });

        // 密码为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            passwordBasicValidator.validate(user);
        });

        // 密码过短 3位
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            user.setPassword("123");
            passwordBasicValidator.validate(user);
        });

        // 密码过短 33位
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            user.setPassword("123456789012345678901234567890123");
            passwordBasicValidator.validate(user);
        });
        // 密码正常 6位
        UserBO user = new UserBO();
        user.setPassword("123456");
        passwordBasicValidator.validate(user);
    }
}