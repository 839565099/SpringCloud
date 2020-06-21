package com.zyq.controller;

import com.zyq.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService service;
    @Value("${server.port}")
    String port;
    @GetMapping("/payment/hystrix/ok")
    public String paymentinfo_OK(@RequestParam Integer id){
        String s = service.paymentinfo_OK(id);
        log.info("~~~~~~~~result: "+s);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout")
    public String paymentinfo_timeOut(@RequestParam Integer id){
        String s = service.paymentinfo_timeOut(id);
        log.info("~~~~~~~~result: "+s);
        return s;
    }

    @GetMapping("/payment/hystrix/circuit")
    public String paymentCircuitBreaker(@RequestParam("id") Integer id){
        String s = service.paymentCircuitBreaker(id);
        log.info("~~~~~~~~~~~~~~: "+s);
        return s;
    }

}
