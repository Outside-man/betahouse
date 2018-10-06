/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.idfactory;

/**
 * Id类型枚举
 *
 * @author dango.yxm
 * @version : IdTypeEnum.java 2018/10/06 下午1:25 dango.yxm
 */
public enum IdTypeEnum {

    USER_ID("0001", "用户id");

    private final String bizNum;

    private final String desc;

    IdTypeEnum(String bizNum, String desc) {
        this.bizNum = bizNum;
        this.desc = desc;
    }

    public String getBizNum() {
        return bizNum;
    }

    public String getDesc() {
        return desc;
    }
}
