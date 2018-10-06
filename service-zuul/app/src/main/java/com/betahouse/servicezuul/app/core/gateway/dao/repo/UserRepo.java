/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.dao.repo;

import com.betahouse.servicezuul.app.core.gateway.dao.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 账户仓储管理
 * @author dango.yxm
 * @version : UserRepo.java 2018/10/05 上午11:13 dango.yxm
 */
@Repository
public interface UserRepo extends JpaRepository<UserDO,Long> {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    UserDO getByUsername(String username);
}
