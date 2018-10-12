/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package service;

import model.UserDTO;
import model.request.UserRegisterRequest;
import model.result.Result;

/**
 * 用户管理对外方法
 *
 * @author dango.yxm
 * @version : UserManagerFacade.java 2018/10/06 下午2:00 dango.yxm
 */
public interface UserManagerFacade {

    /**
     * 注册账号
     * @param request
     * @return
     */
    Result<UserDTO> register(UserRegisterRequest request);
}
