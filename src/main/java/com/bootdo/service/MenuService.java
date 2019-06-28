package com.bootdo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bootdo.domain.dto.MenuDTO;
import com.bootdo.domain.entity.MenuEntity;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:42
 * @Description:
 */
public interface MenuService extends IService<MenuEntity> {

    List<MenuDTO> listMenuByUserId(Long userId);
}
