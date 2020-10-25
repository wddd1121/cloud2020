package com.yh.cloud;

import com.yh.myRule.selfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author yh
 * @date 2020-10-24-14:32
 */
// ribbonClient 指明该服务要访问 CLOUD-PAYMENT-PROVIDER 服务，并且使用 selfRule 负载均衡策论，默认情况下使用的是轮询策略
//@RibbonClient(name = "CLOUD-PAYMENT-PROVIDER", configuration = selfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumer80 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer80.class, args);

    }
}
