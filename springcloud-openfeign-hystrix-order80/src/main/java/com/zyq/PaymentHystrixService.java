package com.zyq;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "SPRINGCLOUD-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok")
    public String paymentinfo_OK(@RequestParam Integer id);

    @GetMapping("/payment/hystrix/timeout")
    public String paymentinfo_timeOut(@RequestParam Integer id);

}
