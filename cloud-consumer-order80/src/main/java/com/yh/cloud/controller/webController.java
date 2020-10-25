package com.yh.cloud.controller;

import com.netflix.discovery.converters.Auto;
import com.yh.cloud.load.loadBalancer;
import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yh
 * @date 2020-10-24-14:35
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class webController {

    //    public static final String payment_url = "http://localhost:8001";
    private static final String payment_url = "http://CLOUD-PAYMENT-PROVIDER";   // 服务为多个端口上的服务，所以需要使用服务名，而不是端口号

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    loadBalancer loadBalancer;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") long id) {
        return restTemplate.getForObject(payment_url + "/payment/get/" + id, CommonResult.class);
    }

    @PostMapping("/payment/save")
    public CommonResult save(Payment payment) {
        return restTemplate.postForObject(payment_url + "/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/payment/getEntity/{id}")
    public CommonResult getEntity(@PathVariable("id") long id) {

        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(payment_url + "/payment/get/" + id, CommonResult.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResult(500, "查询失败");
        }

    }


    // 简单的定义了一个轮询的负载均衡
    @GetMapping("/test/lb/{id}")
    public Object testLoadBalance(@PathVariable("id") long id) {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-PROVIDER");
        ServiceInstance nextService = loadBalancer.getNextService(instances);

        // 通过选出来的service的uri去调用服务
        return restTemplate.getForObject(nextService.getUri().toString() + "/payment/get/" + id, CommonResult.class);
    }


}
