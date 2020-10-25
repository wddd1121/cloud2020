package com.yh.cloud.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-25-10:12
 */
@Configuration
public class config {


    @Bean
    @LoadBalanced   // 不加上该注解，会出现UnknownHostException错误
    public RestTemplate get() {
        return new RestTemplate();
    }
}
