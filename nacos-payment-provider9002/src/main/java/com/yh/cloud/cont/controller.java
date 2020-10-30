package com.yh.cloud.cont;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-29-21:21
 */
@RestController
@RequestMapping("/payment")
public class controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id) {
        return "nacos payment port:" + port + " id:" + id;
    }
}
