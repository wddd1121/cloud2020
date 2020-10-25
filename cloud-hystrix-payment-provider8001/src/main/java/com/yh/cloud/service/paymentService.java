package com.yh.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

/**
 * @author yh
 * @date 2020-10-25-15:53
 */
@Service

public class paymentService {
    Random random = new Random();

    public String serviceSuccess() {
        return "当前处理线程：" + Thread.currentThread().getName() +"";
    }

    public String serviceException(){
        int i = 1/0;
        return "当前处理线程：" + Thread.currentThread().getName() +"";
    }

    // 服务提供者进行服务降级
    // 设置一个兜底的方法，运行超时或者抛出异常都会调用fallback方法
    @HystrixCommand(fallbackMethod = "sleepFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            //3秒钟以内就是正常的业务逻辑，3秒内没有返回值则调用fallbackMethod
    })
    public String serviceSleep(long id){
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前处理线程：" + Thread.currentThread().getName() +" id:"+id;
    }

    public String sleepFallBack(long id){
        return "当前服务繁忙,id:"+id;
    }


    // ====服务熔断
    // 当满足熔断条件后比如大量失败调用，熔断器转为open，open后所有的调用都会被定向到 fallback 方法上
    // 当到休眠窗口期后，会转换为half open，此时会释放一个请求到主逻辑方法中，如果执行成功则熔断器变为close，不成功则还是half open
    @HystrixCommand(fallbackMethod = "paymentFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //休眠窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker( long id) {

        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        return Thread.currentThread().getName() + "  id为：" + id;
    }


    public String paymentFallback(@PathVariable("id") long id) {
        return "id不能为负数，当前id为：" + id;
    }
}
