package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author yh
 * @date 2020-10-25-21:27
 */
@EnableHystrixDashboard // 开启dashboard功能
@SpringBootApplication
public class dashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(dashboard9001.class, args);
    }
}
