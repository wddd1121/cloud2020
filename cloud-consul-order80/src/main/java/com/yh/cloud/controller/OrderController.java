package com.yh.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-25-10:12
 */
@RestController
@RequestMapping("/consumer/consul")
public class OrderController {

    private static final String url = "http://consul-payment-provider";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public String get() {
        return restTemplate.getForObject(url + "/payment/consul/get", String.class);
    }

}
