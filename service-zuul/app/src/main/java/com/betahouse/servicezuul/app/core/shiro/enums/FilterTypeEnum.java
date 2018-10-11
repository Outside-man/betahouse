/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.shiro.enums;

import org.apache.commons.lang.StringUtils;

/**
 * shiro 使用的过滤器类型
 *
 * @author dango.yxm
 * @version : FilterTypeEnum.java 2018/10/11 下午11:51 dango.yxm
 */
public enum FilterTypeEnum {

    /**
     * 匿名 非登录访问
     * 认证 需要登录访问
     */
    ANONYMOUS("anon", "匿名"),
    AUTHENTICATE("authc", "认证");

    private String code;

    private String desc;

    public static FilterTypeEnum getByCode(String code) {
        for (FilterTypeEnum type : values()) {
            if (StringUtils.equals(type.getCode(), code)) {
                return type;
            }
        }
        return null;
    }

    FilterTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
