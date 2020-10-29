package com.yh.cloud.controller.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yh
 * @date 2020-10-29-16:33
 */
@EnableBinding(Source.class)
public class messageSenderImp implements messageSender {

    @Resource(name = "output")
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(message).build());
        System.out.println("发送的message为:"+message);
        return message;
    }
}
