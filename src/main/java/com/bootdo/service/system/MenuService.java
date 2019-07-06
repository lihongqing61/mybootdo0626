package com.bootdo.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bootdo.domain.system.dto.MenuDTO;
import com.bootdo.domain.system.entity.MenuEntity;
import com.bootdo.domain.system.query.MenuVOQuery;
import com.bootdo.domain.system.vo.MenuVO;
import java.util.List;
import java.util.Set;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:42
 * @Description:
 */
public interface MenuService extends IService<MenuEntity> {

    List<MenuDTO> listMenuByUserId(Long userId);

    Set<String> listPerms(Long userId);

    List<MenuVO> list(MenuVOQuery query);
}
