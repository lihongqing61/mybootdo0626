package com.bootdo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootdo.domain.dto.MenuDTO;
import com.bootdo.domain.entity.MenuEntity;
import com.bootdo.mapper.MenuMapper;
import com.bootdo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:43
 * @Description:
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> listMenuByUserId(Long userId) {
        Long parentId = 0L;
        List<MenuDTO> firstMenu = menuMapper.listMenuByUserId(userId, parentId);

        for (MenuDTO menu : firstMenu) {
            List<MenuDTO> secondMenu = menuMapper.listMenuByUserId(userId, menu.getId());
            menu.setSecondMenu(secondMenu);
        }
        return firstMenu;
    }
}
