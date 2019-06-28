package com.bootdo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.dto.MenuDTO;
import com.bootdo.domain.entity.MenuEntity;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/27 20:43
 * @Description:
 */
public interface MenuMapper extends BaseMapper<MenuEntity> {

    List<MenuDTO> listMenuByUserId(@Param("userId") Long userId, @Param("parentId") Long parentId);
}
