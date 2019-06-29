package com.bootdo.controller;

import com.bootdo.common.util.ShiroUtil;
import com.bootdo.domain.system.dto.UserDTO;

/**
 * @Author: lihq
 * @Date: 2019/6/26 10:01
 * @Description: 基础控制层
 */
public class BaseController {

    public static UserDTO getUser() {
        return ShiroUtil.getUser();
    }

    public static Long getUserId() {
        return getUser().getId();
    }

    public static String getUsername() {
        return getUser().getUsername();
    }
}
