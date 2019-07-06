package com.bootdo.controller.system;

import com.bootdo.common.constant.ControllerPrefix;
import com.bootdo.controller.BaseController;
import com.bootdo.domain.system.query.MenuVOQuery;
import com.bootdo.domain.system.vo.MenuVO;
import com.bootdo.service.system.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/7/6 15:34
 * @Description:
 */
@Controller
@Slf4j
@RequestMapping("/menu")
@Api(value = "菜单控制器")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     *  初始化到菜单页面
     * @return
     */
    @GetMapping("/menu")
    public String menu() {
        return ControllerPrefix.MENU_PREFIX + "menu";
    }

    @GetMapping("/list")
    @RequiresPermissions("system:menu:list")
    @ApiOperation(value = "菜单列表查询")
    @ResponseBody
    public List<MenuVO> list(MenuVOQuery query) {
        return menuService.list(query);
    }
}
