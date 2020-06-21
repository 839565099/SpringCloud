package com.zyq.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zyq.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_tHandler")
public class OrderHystrixController {
    @Resource
    PaymentHystrixService service;
    @Value("${server.port}")
    String port;

    @GetMapping("/consumer/payment/hystrix/ok")
    public String paymentInfo_OK(@RequestParam("id") Integer id){
        String s = service.paymentinfo_OK(id);
        log.info("~~~~~~~~: "+s);
        return s;
    }


    @GetMapping("/consumer/payment/hystrix/timeout")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
//            @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000" )//1 秒 钟 以 内 就是正常的 业务逻辑
//    })
    @HystrixCommand
    public String paymentInfo_timeOut(@RequestParam("id") Integer id){
        String s = service.paymentinfo_timeOut(id);
        log.info("~~~~~~~~: "+s);
        return s;
    }

    public String paymentInfo_timeOutHandler(@RequestParam("id") Integer id){
        return "我是调用者80，支付系统繁忙，我不等了～～～～";
    }

    /**
     * 全局fallback
     * @return
     */
    public String global_tHandler(){
        return "我是全局的fallback～～～～";
    }
}

