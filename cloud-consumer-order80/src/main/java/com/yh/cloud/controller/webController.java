package com.yh.cloud.controller;

import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-24-14:35
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class webController {

//    public static final String payment_url = "http://localhost:8001";
    public static final String payment_url = "http://CLOUD-PAYMENT-PROVIDER";   // 服务为多个端口上的服务，所以需要使用服务名，而不是端口号

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") long id) {
        return restTemplate.getForObject(payment_url + "/payment/get/" + id, CommonResult.class);
    }

    @PostMapping("/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(payment_url + "/payment/save", payment, CommonResult.class);
    }



}
