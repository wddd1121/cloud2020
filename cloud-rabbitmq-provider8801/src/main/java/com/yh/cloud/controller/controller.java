package com.yh.cloud.controller;

import com.yh.cloud.controller.service.messageSender;
import com.yh.cloud.controller.service.messageSenderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yh
 * @date 2020-10-29-16:31
 */
@RestController
public class controller {

    @Resource
    private messageSender messageSender;

    @GetMapping("/send")
    public String sendMsg(){
        return messageSender.send();
    }

}
