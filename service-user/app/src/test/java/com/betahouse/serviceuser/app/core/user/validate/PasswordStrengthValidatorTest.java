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
 * 密码强度验证器测试实例
 *
 * @author dango.yxm
 * @version : PasswordStrengthValidatorTest.java 2018/10/05 下午11:14 dango.yxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordStrengthValidatorTest {

    @Autowired
    private PasswordStrengthValidator passwordStrengthValidator;

    @Test
    public void support() {
        AssertUtil.assertTrue(passwordStrengthValidator.support(new UserBO()));
    }

    @Test
    public void validate() {
        // 实体为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            passwordStrengthValidator.validate(null);
        });

        // 密码为空
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            passwordStrengthValidator.validate(user);
        });

        // 密码过于简单
        TestAssertUtil.assertThrow(BetahouseException.class, () -> {
            UserBO user = new UserBO();
            user.setPassword("1");
            passwordStrengthValidator.validate(user);
        });

        // 密码强度覆盖
        UserBO user = new UserBO();
        user.setPassword("1q_A");
        passwordStrengthValidator.validate(user);
    }
}