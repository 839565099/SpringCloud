package com.zyq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 作者：张翼麒
 * Date:2020-6-12
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        log.info("~~~~~~~~~~~~："+serverPort);
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();

    }

}
