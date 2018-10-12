/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.filter;

import org.apache.commons.lang.StringUtils;

/**
 * zuul 网关过滤器类型
 *
 * @author dango.yxm
 * @version : FilterTypeEnum.java 2018/10/12 下午9:17 dango.yxm
 */
public enum FilterTypeEnum {

    /**
     * 网关过滤器类型
     */
    PRE("pre", "预过滤器"),

    ROUTING("routing", "路由过滤器"),

    CUSTOM("custom", "消费过滤器"),

    POST("post", "发送过滤器"),

    ERROR("error", "异常过滤器"),

    ;

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
