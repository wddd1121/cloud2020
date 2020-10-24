package com.yh.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yh
 * @date 2020-10-24-22:08
 */
@RestController
public class controller {

    private static final String url = "http://cloud-payment-provider";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public String get(){
        return restTemplate.getForObject(url+"/payment/get", String.class);
    }

}
