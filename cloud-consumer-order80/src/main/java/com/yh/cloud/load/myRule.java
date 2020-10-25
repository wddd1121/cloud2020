package com.yh.cloud.load;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yh
 * @date 2020-10-25-13:44
 */
public interface myRule {


    ServiceInstance getNextService(List<ServiceInstance> serviceInstances);

}
