package com.bootdo.domain.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: lihq
 * @Date: 2019/6/27 21:04
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class FileEntity implements Serializable {

    private static final long serialVersionUID = 305948274438037090L;

    /**
     *  主键
     */
    private Long id;

    /**
     * 文件类型
     */
    private Integer type;

    /**
     *  URL地址
     */
    private String url;

    /**
     *  创建时间
     */
    private Date createDate;
}
