package com.yh.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-24-22:10
 */
@Configuration
public class applicationConfig {

    @Bean
    public RestTemplate get(){
        return  new RestTemplate();
    }
}
