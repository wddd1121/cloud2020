package com.yh.cloud.load;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yh
 * @date 2020-10-25-13:47
 */
@Component
public class loadBalancer implements myRule {

    private AtomicInteger count = new AtomicInteger(0);

    // 该服务器总共被访问的次数
    private Integer getCount() {
        int now;
        for (; ; ) {
            now = this.count.get();
            if (this.count.compareAndSet(now, ++now)) {
                return now;
            }
        }
    }

    @Override
    public ServiceInstance getNextService(List<ServiceInstance> serviceInstances) {
        Integer count = getCount();
        int size = serviceInstances.size();

        // 通过count求出service的下标
        int nextIndex = count % size;

        return serviceInstances.get(nextIndex);
    }
}
