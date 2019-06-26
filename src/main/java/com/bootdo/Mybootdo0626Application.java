package com.bootdo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: lihq
 * @Date: 2019/6/26 13:58
 * @Description: 主启动类
 */
@SpringBootApplication
// 扫描mapper组件
@MapperScan("com.bootdo.mapper")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class Mybootdo0626Application {

    public static void main(String[] args) {
        SpringApplication.run(Mybootdo0626Application.class, args);
    }

}
