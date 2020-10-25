package com.yh.cloud.controller;

import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.service.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-25-14:43
 */
@RestController
@RequestMapping("/fegin")
public class feginController {

    @Autowired
    private FeginService feginService;


    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") long id){
      return feginService.get(id);
    }


    @GetMapping("/timeout")
    public String feginTimeout(){
        return feginService.testFeginTimeout();
    }

}
