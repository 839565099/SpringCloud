package com.zyq.controller;

import com.zyq.pojo.CommonResult;
import com.zyq.pojo.Payment;
import com.zyq.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 作者：张翼麒
 * Date:2020-6-10
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = service.create(payment);
        log.info("~~~~~！！！插入结果：" + result);
        if (result > 0) {  //成功
            return new CommonResult(200, "插入数据库成功,serverPort: "+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }

    }

    @GetMapping("/getpayment")
    public CommonResult getOne(@RequestParam long id) {
        Payment payment = service.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return new CommonResult(200, "查询成功~!~,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }

    /**
     * 测试手写负载均衡算法
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}