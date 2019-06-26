package com.bootdo.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lihq
 * @Date: 2019/6/26 10:03
 * @Description: 定义结果返回类型
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 1);
        put("msg", "操作成功");
    }

    public static Result error() {
        return error(0, "操作失败");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
