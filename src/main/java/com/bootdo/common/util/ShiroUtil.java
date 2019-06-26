package com.bootdo.common.util;

import com.bootdo.domain.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Author: lihq
 * @Date: 2019/6/26 20:14
 * @Description:
 */
public class ShiroUtil {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserDTO getUser() {
        return (UserDTO) getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getId();
    }
}
