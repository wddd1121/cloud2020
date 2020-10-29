package com.yh.cloud.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yh
 * @date 2020-10-29-19:21
 */
@Component
@EnableBinding(Sink.class)
public class messageListener {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {
        System.out.println("consumer port:" + port + ", message:" + message.getPayload());
    }
}
