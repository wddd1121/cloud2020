package com.yn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-30-8:16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class paymentConsumer9004 {

    public static void main(String[] args) {
        SpringApplication.run(paymentConsumer9004.class, args);
    }
}
