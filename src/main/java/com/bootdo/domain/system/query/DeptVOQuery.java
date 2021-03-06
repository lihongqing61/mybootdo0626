package com.bootdo.domain.system.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bootdo.domain.system.vo.DeptVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: lihq
 * @Date: 2019/6/29 10:32
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class DeptVOQuery extends Page<DeptVO> {

    private static final long serialVersionUID = -4820165814916979910L;

    /**
     *  id
     */
    private Long id;

    /**
     *  parentId 上级部门ID，一级部门为0
     */
    private Long parentId;

    /**
     *  部门名称
     */
    private String name;

    /**
     *  排序
     */
    private Integer orderNum;

    /**
     *  状态 1: 正常, 2: 禁用
     */
    private Integer status;

    /**
     *  是否删除  1：正常  0：已删除
     */
    private Integer delFlag;

}
