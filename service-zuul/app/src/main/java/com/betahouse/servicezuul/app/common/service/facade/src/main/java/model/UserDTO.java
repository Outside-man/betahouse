/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package model;

import com.betahouse.servicezuul.app.common.service.facade.src.main.java.common.ToString;
/**
 * @author dango.yxm
 * @version : UserDTO.java 2018/10/06 下午2:01 dango.yxm
 */
public class UserDTO extends ToString {

    private static final long serialVersionUID = -3784510563032986166L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码(密文)
     */
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
