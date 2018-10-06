/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.biz.facadeimpl;

import com.betahouse.servicezuul.app.biz.template.FacadeOperateTemplate;
import com.betahouse.servicezuul.app.biz.template.OperateCallBack;
import com.betahouse.servicezuul.app.core.gateway.manager.UserManager;
import com.betahouse.servicezuul.app.core.gateway.util.UserConverter;
import enums.CommonResultCode;
import model.UserDTO;
import model.request.UserRegisterRequest;
import model.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserManagerFacade;
import utils.AssertUtil;

/**
 * 用户管理对外实现类
 *
 * @author dango.yxm
 * @version : UserManagerFacadeImpl.java 2018/10/06 下午2:09 dango.yxm
 */
@Service
public class UserManagerFacadeImpl implements UserManagerFacade {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserManagerFacadeImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    public Result<UserDTO> register(UserRegisterRequest request) {
        return FacadeOperateTemplate.operate(LOGGER, "注册用户", request, new OperateCallBack<UserDTO>() {

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
