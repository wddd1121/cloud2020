package com.yn.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-30-8:19
 */
@Configuration
public class config {

    @Bean
    @LoadBalanced
    public RestTemplate get(){
        return new RestTemplate();
    }
}
