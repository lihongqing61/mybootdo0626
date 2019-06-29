package com.bootdo.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootdo.domain.system.dto.MenuDTO;
import com.bootdo.domain.system.entity.MenuEntity;
import com.bootdo.mapper.system.MenuMapper;
import com.bootdo.service.system.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<String> listPerms(Long userId) {
        List<String> perms = menuMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
