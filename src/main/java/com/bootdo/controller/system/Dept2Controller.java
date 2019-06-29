package com.bootdo.controller.system;

import com.bootdo.controller.BaseController;
import com.bootdo.domain.system.vo.DeptVO;
import com.bootdo.service.system.DeptService;
import io.swagger.annotations.ApiOperation;
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
@Controller
@RequestMapping("/system/sysDept")
public class Dept2Controller extends BaseController {

    private String prefix = "system/dept";

    @GetMapping("")
    public String sysDept() {
        return prefix + "/dept";
    }

    @Autowired
    private DeptService deptService;

    @ApiOperation(value="获取部门列表", notes="")
    @ResponseBody
    @GetMapping("/list")
    public List<DeptVO> list(DeptVO vo) {
        return deptService.list(vo);
    }
}
