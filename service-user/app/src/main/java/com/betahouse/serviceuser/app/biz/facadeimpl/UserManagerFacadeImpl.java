/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.biz.facadeimpl;

import com.betahouse.serviceuser.app.biz.template.RestOperateCallBack;
import com.betahouse.serviceuser.app.biz.template.RestOperateTemplate;
import com.betahouse.serviceuser.app.core.user.manager.UserManager;
import com.betahouse.serviceuser.app.core.user.util.UserConverter;
import enums.CommonResultCode;
import model.UserDTO;
import model.request.UserRegisterRequest;
import model.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserManagerFacade;
import utils.AssertUtil;

/**
 * 用户管理对外实现类
 *
 * @author dango.yxm
 * @version : UserManagerFacadeImpl.java 2018/10/06 下午2:09 dango.yxm
 */
@RestController
@RequestMapping(value = "/user")
public class UserManagerFacadeImpl implements UserManagerFacade {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserManagerFacadeImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    @PostMapping("/reg")
    public Result<UserDTO> register(@RequestBody UserRegisterRequest request) {
        return RestOperateTemplate.operate(LOGGER, "注册用户", request, new RestOperateCallBack<UserDTO>() {

            @Override
            public void before() {
                // 校验请求
                AssertUtil.assertNotNull(request, "请求不能为空");
                AssertUtil.assertStringNotBlank(request.getUsername(), "用户名不能为空");
                AssertUtil.assertStringNotBlank(request.getPassword(), "密码不能为空");
            }

            @Override
            public Result<UserDTO> execute() {
                UserDTO dto = UserConverter.BO2DTO(userManager.register(request));
                return new Result<>(true, CommonResultCode.SUCCESS.getErrorCode(), CommonResultCode.SUCCESS.getErrorCode(), dto);
            }
        });
    }
}
