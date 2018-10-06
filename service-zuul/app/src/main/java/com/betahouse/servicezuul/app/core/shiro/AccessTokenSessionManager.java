/**
 * betahouse.us
 * Copyright (c) 2012-2018
 */
package com.betahouse.servicezuul.app.core.shiro;

import com.betahouse.servicezuul.app.common.logger.LoggerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author dango.yxm
 * @version : AccessTokenSessionManager.java 2018/10/04 下午10:59 dango.yxm
 */
public class AccessTokenSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenSessionManager.class);

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 从 header 里面抽出 token
        String token = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        if (StringUtils.isNotBlank(token)) {
            LoggerUtil.info(LOGGER, "获取token, token={0}, model.request={1}, response={2}", token, request, response);
            return token;
        }
        // 取不出 token 按照原逻辑取
        return super.getSessionId(request, response);
    }
}
