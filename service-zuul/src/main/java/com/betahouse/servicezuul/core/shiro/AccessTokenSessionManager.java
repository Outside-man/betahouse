/**
 * betahouse.us
 * Copyright (c) 2012-2018
 */
package com.betahouse.servicezuul.core.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author tuanz
 * @version : AccessTokenSessionManager.java 2018/10/04 下午10:59 tuanz
 */
public class AccessTokenSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 从 header 里面抽出 token
        String token = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        // 取不出 token 按照原逻辑取
        return super.getSessionId(request, response);
    }
}
