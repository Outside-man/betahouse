package com.betahouse.servicezuul.app.core.gateway.manager;

import model.request.UserRegisterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dango.yxm
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void register() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("xxx");
        request.setPassword("aa");
        userManager.register(request);
        userManager.register(request);
    }
}