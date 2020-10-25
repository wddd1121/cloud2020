package com.yh.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yh.cloud.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-25-16:38
 */
@RestController
@DefaultProperties(defaultFallback = "globalFallback")   // 设置全局的默认fallback方法,该方法不能有参数
public class controller {

    @Autowired
    paymentService paymentService;

    @GetMapping("/success")
    public String callSuccess() {
        return paymentService.callSuccess();
    }

    // 服务调用者进行服务降级
    @GetMapping("/sleep/{id}")
//    @HystrixCommand(fallbackMethod = "sleepFallBack", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//            //3秒钟以内就是正常的业务逻辑，3秒内没有返回值则调用fallbackMethod
//    })
    @HystrixCommand
    public String callSleep(@PathVariable("id") long id) {
        return paymentService.callSleep(id);
    }

    public String sleepFallBack(@PathVariable("id") long id) {
        return "id为:" + id + ",consumer发生服务降级";
    }

    public String globalFallback() {
        return "globalFallback生效，consumer服务降级";
    }

    @GetMapping("/exception")
    public String callException() {
        return paymentService.callexception();
    }





}
