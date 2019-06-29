package com.bootdo.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bootdo.domain.system.dto.FileDTO;
import com.bootdo.domain.system.entity.FileEntity;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:03
 * @Description:
 */
public interface FileService extends IService<FileEntity> {

    FileDTO queryFileByPicId(Long picId);
}
