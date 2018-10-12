/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.serviceuser.app.biz.template;


import model.result.Result;

/**
 * 操作模板
 * @author dango.yxm
 * @version : RestOperateCallBack.java 2018/10/06 下午2:19 dango.yxm
 */
public interface RestOperateCallBack<T> {

    default void before(){};

    Result<T> execute();

    default void after(){};
}
