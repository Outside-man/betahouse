/**
 * betahouse.us
 * CopyRight (c) 2012 - 2018
 */
package com.betahouse.servicezuul.app.core.gateway.util;

import com.betahouse.servicezuul.app.core.gateway.dao.model.UserDO;
import com.betahouse.servicezuul.app.core.gateway.model.UserBO;
import model.UserDTO;

/**
 * 用户模型转换器
 *
 * @author dango.yxm
 * @version : UserConverter.java 2018/10/06 下午2:40 dango.yxm
 */
public class UserConverter {

    /**
     * 转换器 UserDO2UserBO
     *
     * @param userDO
     * @return
     */
    public static UserBO DO2BO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserBO userBO = new UserBO();
        userBO.setUserId(userDO.getUserId());
        userBO.setUsername(userDO.getUsername());
        userBO.setPassword(userDO.getPassword());
        userBO.setSalt(userDO.getSalt());
        return userBO;
    }

    /**
     * 转换器 UserBO2UserDO
     *
     * @param userBO
     * @return
     */
    public static UserDO BO2DO(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUserId(userBO.getUserId());
        userDO.setUsername(userBO.getUsername());
        userDO.setPassword(userBO.getPassword());
        userDO.setSalt(userBO.getSalt());
        return userDO;
    }

    /**
     * 转换器 UserBO2UserDO
     *
     * @param userBO
     * @return
     */
    public static UserDTO BO2DTO(UserBO userBO) {
        if (userBO == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userBO.getUserId());
        userDTO.setUsername(userBO.getUsername());
        userDTO.setPassword(userBO.getPassword());
        return userDTO;
    }
}
