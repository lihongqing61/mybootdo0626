package com.bootdo.service.file.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bootdo.domain.system.dto.FileDTO;
import com.bootdo.domain.system.entity.FileEntity;
import com.bootdo.mapper.file.FileMapper;
import com.bootdo.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:08
 * @Description:
 */
@Service
public class FileServiceService extends ServiceImpl<FileMapper, FileEntity> implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public FileDTO queryFileByPicId(Long picId) {
        return fileMapper.queryFileByPicId(picId);
    }
}
