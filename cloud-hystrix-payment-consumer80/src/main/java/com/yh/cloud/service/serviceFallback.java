package com.yh.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yh
 * @date 2020-10-25-19:28
 */
@Component
public class serviceFallback implements paymentService {

    @Override
    public String callSuccess() {
        return "fallback for callSuccess";
    }

    @Override
    public String callexception() {
        return "fallback for callexception";

    }

    @Override
    public String callSleep(long id) {
        return "fallback for callSleep";

    }
}
