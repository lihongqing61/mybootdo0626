package com.bootdo.controller;

import com.bootdo.common.util.MD5Util;
import com.bootdo.common.util.Result;
import com.bootdo.common.util.ShiroUtil;
import com.bootdo.domain.dto.FileDTO;
import com.bootdo.domain.dto.MenuDTO;
import com.bootdo.service.FileService;
import com.bootdo.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/26 10:01
 * @Description: 登录控制层
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private FileService fileService;

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
     * 登录成功后 跳转到首页
     * @return
     */
    @GetMapping(value = {"/index"})
    public String index(Model model) {
        //1. 查询用户拥有的菜单
        List<MenuDTO> menus = menuService.listMenuByUserId(getUserId());
        model.addAttribute("menus", menus);

        //2. 查询头像
        FileDTO file = fileService.queryFileByPicId(getUser().getPicId());
        if (file == null || StringUtils.isEmpty(file.getUrl())) {
            model.addAttribute("picUrl", "/img/photo_s.jpg");
        } else {
            model.addAttribute("picUrl", file.getUrl());
        }

        model.addAttribute("name", getUser().getName());
        model.addAttribute("username", getUsername());
        return "index";
    }

    /**
     *  提交登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     *  主页
     * @return
     */
    @GetMapping("/main")
    String main() {
        return "main";
    }

    /**
     *  退出
     * @return
     */
    @GetMapping("/logout")
    String logout() {
        ShiroUtil.logout();
        return "redirect:/login";
    }
}
