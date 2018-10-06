/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package model.request;

import com.betahouse.servicezuul.app.common.service.facade.src.main.java.common.ToString;
/**
 * 用户注册请求
 *
 * @author dango.yxm
 * @version : UserRegisterRequest.java 2018/10/05 下午11:06 dango.yxm
 */
public class UserRegisterRequest extends ToString {

    private static final long serialVersionUID = -2696566376275061324L;

    // 用户名
    private String username;

    // 密码
    private String password;

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
