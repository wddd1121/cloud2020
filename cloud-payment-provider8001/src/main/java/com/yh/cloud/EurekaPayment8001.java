package com.yh.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yh
 * @date 2020-10-24-11:45
 */
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.yh.cloud.dao")
@SpringBootApplication
public class EurekaPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaPayment8001.class, args);
    }


}
