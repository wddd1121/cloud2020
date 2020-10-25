package com.yh.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yh
 * @date 2020-10-25-16:36
 */
@Component
@FeignClient(name = "HYSTRIX-PAYMENT-PROVIDER", fallback = serviceFallback.class)   // 在服务调用时进行服务降级
public interface paymentService {

    @GetMapping("/success")
     String callSuccess();

    @GetMapping("/exception")
     String callexception();

    @GetMapping("/sleep/{id}")
    String callSleep(@PathVariable("id") long id);
}
