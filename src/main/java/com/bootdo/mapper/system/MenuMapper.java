package com.bootdo.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.system.dto.MenuDTO;
import com.bootdo.domain.system.entity.MenuEntity;
import com.bootdo.domain.system.query.MenuVOQuery;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:43
 * @Description:
 */
public interface MenuMapper extends BaseMapper<MenuEntity> {

    List<MenuDTO> listMenuByUserId(@Param("userId") Long userId, @Param("parentId") Long parentId);

    List<String> listUserPerms(Long userId);

    List<MenuDTO> list(MenuVOQuery query);
}
