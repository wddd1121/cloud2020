package com.yh.cloud.contoller;

import com.yh.cloud.service.paymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yh
 * @date 2020-10-25-16:02
 */
@RestController
@Slf4j
public class controller {

    @Autowired
    paymentService paymentService;

    @GetMapping("/success")
    public String callSuccess() {
        int i = 10 / 0;
        String result = paymentService.serviceSuccess();
        log.info(result);
        return result;

    }

    @GetMapping("/exception")
    public String callexception() {
        String result = paymentService.serviceException();
        log.info(result);
        return result;

    }

    @GetMapping("/sleep/{id}")
    public String callSleep(@PathVariable("id") long id) {
        String result = paymentService.serviceSleep(id);
        log.info(result);
        return result;

    }

    @GetMapping("/test/circuit/{id}")
    public String testCircuit(@PathVariable("id") long id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
