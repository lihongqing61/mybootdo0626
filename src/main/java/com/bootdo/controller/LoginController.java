package com.bootdo.controller;

import com.bootdo.common.util.MD5Util;
import com.bootdo.common.util.Result;
import com.bootdo.domain.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lihq
 * @Date: 2019/6/26 10:01
 * @Description: 登录控制层
 */
@Controller
public class LoginController extends BaseController {

    /**
     *  跳转到主页
     * @return
     */
    @GetMapping(value = {"/", ""})
    public String welcome() {
          return "blog/index/main";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = {"/login"})
    public String login() {
        return "login";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = {"/index"})
    public String index() {
        UserDTO user = getUser();
        return "index";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password) {

        password = MD5Util.encrypt(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Result.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.error(e.getMessage());
        } catch (LockedAccountException e) {
            return Result.error(e.getMessage());
        }
        return Result.ok();
    }
}
