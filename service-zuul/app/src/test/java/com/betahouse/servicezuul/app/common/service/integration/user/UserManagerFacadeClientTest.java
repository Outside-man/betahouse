package com.betahouse.servicezuul.app.common.service.integration.user;

import model.request.UserRegisterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerFacadeClientTest {

    @Autowired
    private UserManagerFacadeClient userManagerFacadeClient;

    @Test
    public void register() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("1111");
        request.setPassword("2222");

        System.out.println(userManagerFacadeClient.register(request));
    }
}