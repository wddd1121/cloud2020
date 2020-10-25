package com.yh.cloud.service;

import com.yh.cloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yh
 * @date 2020-10-25-14:40
 */
@Component
@FeignClient(value = "cloud-payment-provider")
public interface FeginService {

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Long id);

    @GetMapping("/payment/fegin/timeout")
    String testFeginTimeout();

}
