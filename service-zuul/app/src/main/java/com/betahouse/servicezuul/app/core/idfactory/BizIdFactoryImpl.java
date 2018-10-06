/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.idfactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import utils.DateUtil;

import java.util.Date;

/**
 * @author dango.yxm
 * @version : BizIdFactoryImpl.java 2018/10/06 下午1:28 dango.yxm
 */
@Service
public class BizIdFactoryImpl implements BizIdFactory {

    /**
     * 随机数范围
     */
    private static int RANDOM_RANGE = 100000000;

    @Override
    public String getUserId() {
        StringBuilder builder = new StringBuilder(32);
        Date now = new Date();
        // 1-16 系统时间
        builder.append(DateUtil.getShortDatesStr(now));
        // 16-24 随机数
        builder.append(getRandNum(8));
        // 24-28 业务码
        builder.append(IdTypeEnum.USER_ID.getBizNum());
        // 28-32 业务自定义码
        builder.append(DateUtil.getYear(now));
        return builder.toString();
    }

    /**
     * 获取指定长度的随机数，不足向左补0
     *
     * @param length
     * @return
     */
    private String getRandNum(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("截取长度非法");
        }
        String numStr = String.valueOf((int) (Math.random() * 100000000));
        numStr = StringUtils.right(numStr, length);
        if (StringUtils.isBlank(numStr)) {
            return getZeroString(length);
        }
        if (length > numStr.length()) {
            return getZeroString(length - numStr.length()) + numStr;
        }
        return numStr;
    }

    /**
     * 获取长度lenth的0字符串
     *
     * @param lenth
     * @return
     */
    private String getZeroString(int lenth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenth; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
