package com.yh.cloud.service;

import com.yh.cloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yh
 * @date 2020-10-31-20:53
 */
@FeignClient(name = "seata-store-service")
public interface storeService {

    @GetMapping("/decreaseStore")
    CommonResult decreaseStore(@RequestParam("productId") Long productId,
                                      @RequestParam("count") int count);

}
