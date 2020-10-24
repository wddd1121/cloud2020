package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-24-20:37
 */
@EnableDiscoveryClient  // 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
public class payment8004 {

    public static void main(String[] args) {
        SpringApplication.run(payment8004.class, args);
    }

}
