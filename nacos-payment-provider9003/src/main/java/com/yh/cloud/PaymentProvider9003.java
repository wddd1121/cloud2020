package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-29-21:20
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentProvider9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider9003.class, args);
    }
}
