package com.bootdo.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootdo.common.util.ConverterUtil;
import com.bootdo.common.util.PropertiesUtil;
import com.bootdo.common.util.Result;
import com.bootdo.domain.system.dto.DeptDTO;
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
        List<DeptDTO> dtoList = deptMapper.list(vo);
        return ConverterUtil.copyList(dtoList, DeptVO.class);
    }

    @Override
    public Result delete(DeptEntity entity) {
        Long count = deptMapper.count(entity);
        if (count > 0) {
            return Result.error(PropertiesUtil.getValue("deleteDept"));
        }
        boolean result = updateById(entity);
        if (result) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}
