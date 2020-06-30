package com.zyq.service.impl;

import com.zyq.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)//定义消息打推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送通道

    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(s).build());
        log.info("~~~~~~~: " + send);
        return null;
    }
}
