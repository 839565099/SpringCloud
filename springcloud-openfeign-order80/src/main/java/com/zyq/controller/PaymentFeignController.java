package com.zyq.controller;

import com.zyq.pojo.CommonResult;
import com.zyq.pojo.Payment;
import com.zyq.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentFeignController {
    @Resource
    PaymentFeignService service;
    @GetMapping("/consumer/payment/get/feign")
    public CommonResult<Payment> getPayment(@RequestParam("id") long id){
        CommonResult one = service.getOne(id);
        return one;
    }
    @GetMapping("/consumer/payment/get/string")
    public String getString(){
        String one = service.getServerString();
        return one;
    }
}
