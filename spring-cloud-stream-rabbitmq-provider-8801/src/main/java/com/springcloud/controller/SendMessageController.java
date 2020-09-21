package com.springcloud.controller;

import com.springcloud.service.IMessageProviderSV;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProviderSV messageProviderSV;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProviderSV.send();
    }

}
