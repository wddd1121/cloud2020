package com.yn.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PipedReader;

/**
 * @author yh
 * @date 2020-10-30-8:17
 */
@RestController
@Slf4j
public class controller {

    @Value("${service-url.nacos-user-service}")
    private String service;


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/get/{id}")
    public String getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(service + "/payment/get/" + id, String.class);
    }


}
