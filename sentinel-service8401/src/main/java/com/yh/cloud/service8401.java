package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-30-20:42
 */
@EnableDiscoveryClient
@SpringBootApplication
public class service8401 {

    public static void main(String[] args) {
        SpringApplication.run(service8401.class, args);
    }
}
