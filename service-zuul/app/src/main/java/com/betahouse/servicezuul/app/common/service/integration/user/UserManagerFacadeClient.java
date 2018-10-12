/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.common.service.integration.user;

import model.UserDTO;
import model.request.UserRegisterRequest;
import model.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.UserManagerFacade;

/**
 * @author dango.yxm
 * @version : UserManagerFacadeClient.java 2018/10/13 上午12:29 dango.yxm
 */
@FeignClient("service-user")
public interface UserManagerFacadeClient extends UserManagerFacade {

    @PostMapping("/user/reg")
    Result<UserDTO> register(@RequestBody UserRegisterRequest request);
}
