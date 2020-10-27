package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yh
 * @date 2020-10-27-19:08
 */
@SpringBootApplication
@EnableEurekaClient
public class gateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(gateway9527.class, args);
    }
}
