package com.bootdo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bootdo.domain.dto.FileDTO;
import com.bootdo.domain.entity.FileEntity;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:03
 * @Description:
 */
public interface FileService extends IService<FileEntity> {

    FileDTO queryFileByPicId(Long picId);
}
