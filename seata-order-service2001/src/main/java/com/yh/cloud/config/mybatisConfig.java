package com.yh.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yh
 * @date 2020-10-31-20:41
 */
@Configuration
@MapperScan({"com.yh.cloud.dao"})
public class mybatisConfig {
}
