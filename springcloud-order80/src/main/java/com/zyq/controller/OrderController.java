package com.zyq.controller;

import com.zyq.pojo.CommonResult;
import com.zyq.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 作者：张翼麒
 * Date:2020-6-11
 */
@RestController
@Slf4j
public class OrderController {
//    不能写死
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL="http://SPRINGCLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/payment/getpayment")
    public CommonResult<Payment> getPayment(@RequestParam long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/getpayment/?id=" + id, CommonResult.class);


    }

}
