package com.bootdo.mapper.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bootdo.domain.system.dto.FileDTO;
import com.bootdo.domain.system.entity.FileEntity;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:08
 * @Description:
 */
public interface FileMapper extends BaseMapper<FileEntity> {

    FileDTO queryFileByPicId(Long picId);
}
