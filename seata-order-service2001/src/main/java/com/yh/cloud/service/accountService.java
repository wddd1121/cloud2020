package com.yh.cloud.service;

import com.yh.cloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yh
 * @date 2020-10-31-20:53
 */
@FeignClient(name = "seata-account-service")
public interface accountService {

    @GetMapping("/decreaseMoney")
    CommonResult decreaseMoney(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal count);
}
