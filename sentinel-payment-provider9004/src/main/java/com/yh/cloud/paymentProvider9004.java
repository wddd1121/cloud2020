package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-31-15:15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class paymentProvider9004 {

    public static void main(String[] args) {
        SpringApplication.run(paymentProvider9004.class, args);
    }
}
