package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-30-8:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class configClient9005 {

    public static void main(String[] args) {
        SpringApplication.run(configClient9005.class, args);
    }
}
