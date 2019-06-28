package com.bootdo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.dto.FileDTO;
import com.bootdo.domain.entity.FileEntity;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:08
 * @Description:
 */
public interface FileMapper extends BaseMapper<FileEntity> {

    FileDTO queryFileByPicId(Long picId);
}
