package com.bootdo.domain.dto;

import com.bootdo.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:29
 * @Description: 菜单实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class MenuDTO extends BaseEntity {

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    List<MenuDTO> secondMenu;
}
