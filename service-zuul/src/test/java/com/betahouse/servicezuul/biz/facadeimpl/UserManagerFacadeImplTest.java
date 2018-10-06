package com.betahouse.servicezuul.biz.facadeimpl;

import model.request.UserRegisterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerFacadeImplTest {

    @Autowired
    private UserManagerFacadeImpl userManagerFacade;

    @Test
    public void register() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("11");
        request.setPassword("222");
        System.out.println(userManagerFacade.register(request));
        System.out.println(userManagerFacade.register(request));
        System.out.println(userManagerFacade.register(request));

    }
}