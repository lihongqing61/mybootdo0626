package com.bootdo.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootdo.domain.system.entity.DeptEntity;
import com.bootdo.domain.system.vo.DeptVO;
import com.bootdo.mapper.system.DeptMapper;
import com.bootdo.service.system.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lihq
 * @Date: 2019/6/29 10:40
 * @Description:
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptEntity> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<DeptVO> list(DeptVO vo) {
        return deptMapper.list(vo);
    }
}
