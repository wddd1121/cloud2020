package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author yh
 * @date 2020-10-25-8:15
 */
@SpringBootApplication
@EnableDiscoveryClient

public class ConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006.class, args);

    }
}
