package com.betahouse.serviceuser.app.core.user.manager;

import com.betahouse.serviceuser.app.common.dao.service.UserService;
import com.betahouse.serviceuser.app.core.user.model.UserBO;
import model.request.UserRegisterRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import validator.MultiValidator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 用户管理测试
 *
 * @author dango.yxm
 * @version : UserManagerTest.java 2018/10/30 上午00:14 dango.yxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest {

    //    @Autowired
    private UserManager userManager;

    private UserService mockUserService;

    @Before
    public void before() {
        mockUserService = mock(UserService.class);
        MultiValidator mockUserRegisterValidator = mock(MultiValidator.class);
        ReflectionTestUtils.setField(userManager, "userService", mockUserService);
        ReflectionTestUtils.setField(userManager, "userRegisterValidator", mockUserRegisterValidator);

    }

    @Test
    public void register() {
        when(mockUserService.insertUser(any())).thenReturn(new UserBO());
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setUsername("1122a1");
        registerRequest.setPassword("111aaxxxs");
        userManager.register(registerRequest);
    }
}