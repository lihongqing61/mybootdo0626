package com.bootdo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.dto.UserDTO;
import com.bootdo.domain.entity.UserEntity;
import com.bootdo.domain.query.UserVOQuery;
import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/26 13:49
 * @Description:
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserDTO> queryUser(UserVOQuery query);
}
