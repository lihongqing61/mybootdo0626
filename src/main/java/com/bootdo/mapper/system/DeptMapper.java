package com.bootdo.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.system.entity.DeptEntity;
import com.bootdo.domain.system.vo.DeptVO;

import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/29 10:39
 * @Description:
 */
public interface DeptMapper extends BaseMapper<DeptEntity> {

    List<DeptVO> list(DeptVO vo);
}
