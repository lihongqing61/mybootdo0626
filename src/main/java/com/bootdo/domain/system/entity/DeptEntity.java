package com.bootdo.domain.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

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
@TableName("sys_dept")
public class DeptEntity implements Serializable {

    private static final long serialVersionUID = 202758907327877147L;

    /**
     *  id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
