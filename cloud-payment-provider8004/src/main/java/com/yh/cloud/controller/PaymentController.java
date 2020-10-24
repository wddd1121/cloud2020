package com.yh.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


/**
 * @author yh
 * @date 2020-10-24-13:40
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;



    @GetMapping("/get")
    public String get() {

        return "zookeeper:"+port+ UUID.randomUUID().toString();
    }


}
