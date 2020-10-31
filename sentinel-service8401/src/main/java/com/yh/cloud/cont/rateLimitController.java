package com.yh.cloud.cont;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-31-14:31
 */
@RestController
public class rateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")    // 定义一个限流处理方法
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException e) {
        return new CommonResult(444,e.getClass().getCanonicalName()+"\t 服务不可用");
    }



    @GetMapping("/testHandle")
    @SentinelResource(value = "testHandle",blockHandlerClass = blockHandler.class, blockHandler = "handleBlock1")    // 定义类中的方法
    public CommonResult testHandle() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

}


