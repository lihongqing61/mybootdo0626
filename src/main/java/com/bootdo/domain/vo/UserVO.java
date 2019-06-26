package com.bootdo.domain.vo;

import com.bootdo.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * @Author: lihq
 * @Date: 2019/6/25 15:15
 * @Description: 用户实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class UserVO extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态 0:禁用，1:正常
     */
    private Integer status;

    /**
     * 性别 1: 男, 2: 女
     */
    private Long sex;

    /**
     * 出身日期
     */
    private Date birth;

    /**
     * 图片ID
     */
    private Long picId;

    /**
     * 现居住地
     */
    private String liveAddress;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 省份
     */
    private String provinceId;

    /**
     * 所在城市
     */
    private String cityId;

    /**
     * 所在地区
     */
    private String districtId;

}
