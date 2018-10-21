/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package model.request;

import common.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础请求体
 *
 * @author dango.yxm
 * @version : BaseRequest.java 2018/10/21 下午3:17 dango.yxm
 */
public class BaseRequest extends ToString {

    private static final long serialVersionUID = 6204283779109664837L;

    /**
     * 请求id 用于幂等
     */
    private String requestId;

    /**
     * 拓展信息
     */
    private Map<String, String> extInfo;

    /**
     * 存入拓展信息
     *
     * @param key
     * @param value
     */
    public void putExt(String key, String value) {
        if (extInfo == null) {
            extInfo = new HashMap<>();
        }
        extInfo.put(key, value);
    }

    /**
     * 取出拓展信息
     *
     * @param key
     * @return
     */
    public String getExt(String key) {
        if (extInfo == null) {
            return null;
        }
        return extInfo.get(key);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, String> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, String> extInfo) {
        this.extInfo = extInfo;
    }
}
