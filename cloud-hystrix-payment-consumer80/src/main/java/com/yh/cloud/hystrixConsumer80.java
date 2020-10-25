package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yh
 * @date 2020-10-25-16:32
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class hystrixConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(hystrixConsumer80.class, args);
    }
}
