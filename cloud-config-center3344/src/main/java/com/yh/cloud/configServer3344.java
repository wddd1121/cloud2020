package com.yh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yh
 * @date 2020-10-28-15:59
 */
@SpringBootApplication
@EnableConfigServer
public class configServer3344 {


    public static void main(String[] args) {
        SpringApplication.run(configServer3344.class, args);
    }
}
