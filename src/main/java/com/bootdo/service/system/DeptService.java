package com.bootdo.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bootdo.domain.system.entity.DeptEntity;
import com.bootdo.domain.system.vo.DeptVO;

import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/29 10:39
 * @Description:
 */
public interface DeptService extends IService<DeptEntity> {

    List<DeptVO> list(DeptVO vo);
}
