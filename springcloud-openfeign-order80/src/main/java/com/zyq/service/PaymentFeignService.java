package com.zyq.service;

import com.zyq.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Component
@FeignClient("SPRINGCLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 测试openfeign调用
     * @param id
     * @return
     */
    @GetMapping("/getpayment")
     CommonResult getOne(@RequestParam long id);

    /**
     * 测试openfeign超时控制
     * @return
     */
    @GetMapping("/getString")
    public String getServerString();
}
