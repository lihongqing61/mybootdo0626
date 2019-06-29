package com.bootdo.controller.system;

import com.bootdo.controller.BaseController;
import com.bootdo.domain.system.vo.DeptVO;
import com.bootdo.service.system.DeptService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/28 21:21
 * @Description:
 */
//@Controller
//@RequestMapping("/dept")
public class DeptController extends BaseController {

    private String prefix = "system/dept";

    @Autowired
    private DeptService deptService;

    /**
     *  返回到部门初始化页面
     * @return
     */
    @GetMapping("/dept/sysDept")
    public String sysDept() {
        return prefix + "/dept";
    }

    @ApiOperation(value="获取部门列表", notes="")
    @ResponseBody
    @GetMapping("/system/sysDept/list")
    public List<DeptVO> list(DeptVO vo) {
        return deptService.list(vo);
    }
}
