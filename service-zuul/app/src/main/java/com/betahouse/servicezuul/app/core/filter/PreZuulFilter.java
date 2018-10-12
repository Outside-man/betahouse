/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.filter;

import com.betahouse.servicezuul.app.common.util.constant.LoggerNameConstant;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import utils.LoggerUtil;

/**
 * zuul 预处理器
 *
 * @author dango.yxm
 * @version : PreZuulFilter.java 2018/10/12 下午9:16 dango.yxm
 */
@Component
public class PreZuulFilter extends ZuulFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggerNameConstant.ZUUL_FILTER);

    /**
     * 过滤器类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterTypeEnum.PRE.getCode();
    }

    /**
     * 执行顺序 0最优
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器处理条件
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 处理内容
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        LoggerUtil.info(LOGGER, "[PreZuulFilter] this is zuul Filter");
        return null;
    }
}
