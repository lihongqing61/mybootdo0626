package com.bootdo.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.system.dto.UserDTO;
import com.bootdo.domain.system.entity.UserEntity;
import com.bootdo.domain.system.query.UserVOQuery;

import java.util.List;

/**UserVOQuery
 * @Author: lihq
 * @Date: 2019/6/26 13:49
 * @Description:
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserDTO> queryUser(UserVOQuery query);
}
