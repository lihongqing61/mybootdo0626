package com.bootdo.domain.system.dto;

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
public class DeptDTO implements Serializable {

    private static final long serialVersionUID = -1050493065229773528L;

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
     *  是否删除  1：正常  0：已删除
     */
    private Integer delFlag;
}