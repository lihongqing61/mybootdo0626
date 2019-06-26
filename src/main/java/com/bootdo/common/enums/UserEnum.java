package com.bootdo.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Author: lihq
 * @Date: 2019/6/26 9:28
 * @Description: 用户枚举类型
 */
@NoArgsConstructor
@AllArgsConstructor
public enum UserEnum {

    UNKNOW_ACCOUNT(1000, "用户不存在"),
    INCORRENT_PASSWORD(1001, "密码不正确"),
    ACCOUNT_LOCK(1002, "账号被锁定 请联系管理员")
    ;

    /**
     *  状态码
     */
    private int code;

    /**
     *  状态码信息
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
