package com.yh.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yh
 * @date 2020-10-25-15:14
 */
@Configuration
public class feginConfig {

    // 开始fegin的日志功能，日志级别为详细
    @Bean
    Logger.Level get(){
        return Logger.Level.FULL;
    }
}
