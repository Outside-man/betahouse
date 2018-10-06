/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 登陆规则
 * @author dango.yxm
 * @version : LoginRealm.java 2018/10/04 下午11:17 dango.yxm
 */
public class LoginRealm extends AuthorizingRealm {

    /**
     * 用于登陆鉴定
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
