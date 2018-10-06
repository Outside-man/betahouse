package com.betahouse.servicezuul.core.gateway.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import model.request.UserRegisterRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void register() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("11");
        request.setPassword("222");
        System.out.println(userManager.register(request));
    }
}