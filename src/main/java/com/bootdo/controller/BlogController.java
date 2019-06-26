package com.bootdo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lihq
 * @Date: 2019/6/26 16:22
 * @Description:
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @GetMapping(value = {""})
    public String blog() {
        return "blog/index/main";
    }
}
