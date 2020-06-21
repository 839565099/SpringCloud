package com.zyq;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentinfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬ ＿ ┬)";
    }

    @Override
    public String paymentinfo_timeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬ ＿ ┬)";
    }
}
