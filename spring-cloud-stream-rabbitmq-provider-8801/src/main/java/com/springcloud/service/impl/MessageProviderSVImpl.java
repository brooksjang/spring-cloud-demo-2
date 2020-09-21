package com.springcloud.service.impl;

import com.springcloud.service.IMessageProviderSV;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)  //指出channel和exchange绑定在一起，定义消息的推送管道
public class MessageProviderSVImpl implements IMessageProviderSV {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("*********serial：" + uuid);
        return null;
    }
}
