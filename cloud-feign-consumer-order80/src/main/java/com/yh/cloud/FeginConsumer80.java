package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yh
 * @date 2020-10-25-14:35
 */
@EnableFeignClients
//@EnableEurekaClient
@SpringBootApplication
public class FeginConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(FeginConsumer80.class, args);
    }
}
