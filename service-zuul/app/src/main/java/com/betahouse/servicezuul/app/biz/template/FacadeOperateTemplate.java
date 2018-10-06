/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.biz.template;

import com.betahouse.servicezuul.app.common.logger.LoggerUtil;
import enums.CommonResultCode;
import exceptions.BetahouseException;
import model.result.Result;
import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * facade操作模板类
 *
 * @author dango.yxm
 * @version : FacadeOperateTemplate.java 2018/10/06 下午2:12 dango.yxm
 */
public class FacadeOperateTemplate {

    /**
     * 操作模板
     * @param logger 日志
     * @param methodName 方法名称 标识
     * @param request 请求
     * @param callBack 操作方法
     * @param <T> 结果实体
     * @return
     */
    public static <T> Result<T> operate(Logger logger, String methodName, Object request, OperateCallBack<T> callBack) {
        long start = System.currentTimeMillis();
        Result<T> result = null;
        try {
            //操作前置
            callBack.before();

            //执行操作
            result = callBack.execute();

            //操作后置
            callBack.after();
            return result;
        } catch (BetahouseException be) {
            LoggerUtil.warn(be, logger, "FacadeOperateTemplate.operate fail, methodName={0}, request={1}, errorCode={2}, errorMsg={3}", methodName, request, be.getErrorCode(), be.getErrorMsg());
            return new Result<>(false, be.getErrorCode(), be.getErrorMsg());
        } catch (Exception e) {
            LoggerUtil.error(e, logger, "FacadeOperateTemplate.operate error, methodName={0}, request={1}", methodName, request);
            return new Result<>(false, CommonResultCode.SYSTEM_ERROR.getErrorCode(), CommonResultCode.SYSTEM_ERROR.getErrorMsg());
        } catch (Throwable t) {
            LoggerUtil.error(t, logger, "FacadeOperateTemplate.operate throwable, methodName={0}, request={1}", methodName, request);
            return new Result<>(false, CommonResultCode.SYSTEM_ERROR.getErrorCode(), CommonResultCode.SYSTEM_ERROR.getErrorMsg());
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(MessageFormat.format("FacadeOperateTemplate.operate final, methodName={0}, consume={1}ms, request={2}, result={3}", methodName, end - start, request, result));
            LoggerUtil.info(logger, "FacadeOperateTemplate.operate final, methodName={0}, consume={1}ms, request={2}, result={3}", methodName, end - start, request, result);
        }
    }
}
