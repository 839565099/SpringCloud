package com.zyq.controller;


import com.zyq.lb.LoadBalancer;
import com.zyq.pojo.CommonResult;
import com.zyq.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

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
    /**
     * 引入自己写的负载均衡算法
     */
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/payment/getpayment")
    public CommonResult<Payment> getPayment(@RequestParam long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/getpayment/?id=" + id, CommonResult.class);


    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        //获取对应微服务名所以对应的微服务实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");
        if (instances==null || instances.size()<0){
            return null;
        }
        //丢入方法，返回应该调用的微服务实例
        ServiceInstance instance = loadBalancer.INSTANCE(instances);
        //获取改微服务uri
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

}
