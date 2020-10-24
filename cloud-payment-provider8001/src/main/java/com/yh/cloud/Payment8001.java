package com.yh.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yh
 * @date 2020-10-24-11:45
 */
@MapperScan("com.yh.cloud.dao")
@SpringBootApplication
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class, args);
    }


}
