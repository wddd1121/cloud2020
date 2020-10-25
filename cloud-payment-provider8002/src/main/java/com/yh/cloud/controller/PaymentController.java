package com.yh.cloud.controller;

import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import com.yh.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


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


    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {    // 另外一个服务调用此接口时，需要加上@requestBody，不然属性注入不到这个payment中
        int result = paymentService.save(payment);
        log.info("插入数据结果======" + result);

        if (result > 0) {
            return new CommonResult<>(200, "插入成功，端口号为:"+port, result);
        } else {
            return new CommonResult<>(500, "插入失败");
        }

    }

    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment payment = paymentService.get(id);
        log.info("查询数据结果======" + payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功，端口号为:"+port, payment);
        } else {
            return new CommonResult<>(500, "查询失败");
        }

    }


    @GetMapping("/test/lb")
    public String testLoadBalance() {
        return "测试自定义负载均衡" + port;
    }


    @GetMapping("/fegin/timeout")
    public String testFeginTimeout(){
        try {
            log.info("调用延迟0.5秒的服务");
            // fegin客户端默认等待1秒，如果1秒没有拿到结果则会报错
            // 这里模拟0.5秒后返回结果
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return port;
    }

}
