package com.bootdo.controller.system;

import com.bootdo.common.constant.NumberConstant;
import com.bootdo.common.util.PropertiesUtil;
import com.bootdo.common.util.Result;
import com.bootdo.controller.BaseController;
import com.bootdo.domain.system.entity.DeptEntity;
import com.bootdo.domain.system.vo.DeptVO;
import com.bootdo.service.system.DeptService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/28 21:21
 * @Description:
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

    private String prefix = "system/dept";

    @Autowired
    private DeptService deptService;


    /**
     *  返回到部门初始化页面
     * @return
     */
    @GetMapping("/dept")
    public String sysDept() {
        return prefix + "/dept";
    }

    /**
     * 列表页面
     * @param vo
     * @return
     */
    @ApiOperation(value="获取部门列表", notes="")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions(value = "system:dept:list")
    public List<DeptVO> list(DeptVO vo) {
        return deptService.list(vo);
    }

    /**
     *  跳转到部门新增页面
     * @param pId
     * @param model
     * @return
     */
    @GetMapping("/add/{pId}")
    public String add(@PathVariable(value = "pId") Long pId, Model model) {
        if (pId == 0) {
            model.addAttribute("pName", PropertiesUtil.getValue("pName"));
        } else {
            model.addAttribute("pName", deptService.getById(pId).getName());
        }
        return prefix + "/add";
    }

    /**
     *  新增部门
     * @param entity 部门对象
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    @RequiresPermissions(value = "system:dept:add")
    public Result save(DeptEntity entity) {
        boolean result = deptService.save(entity);
        if (result) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    /**
     * 跳转到部门修改页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        DeptEntity dept = deptService.getById(id);
        model.addAttribute("dept", dept);
        if (NumberConstant.NUMBER0.equals(dept.getParentId())) {
            model.addAttribute("pName", PropertiesUtil.getValue("pName"));
        } else {
            DeptEntity parentDept = deptService.getById(dept.getParentId());
            model.addAttribute("pName", parentDept.getName());
        }
        return prefix + "/edit";
    }

    /**
     *  修改部门
     * @param entity 部门对象
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    @RequiresPermissions(value = "system:dept:edit")
    public Result update(DeptEntity entity) {
        boolean result = deptService.updateById(entity);
        if (result) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    /**
     * 部门删除
     * @param entity
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    @RequiresPermissions(value = "system:dept:remove")
    public Result delete(DeptEntity entity) {
        return deptService.delete(entity);
    }
}
