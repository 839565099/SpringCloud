package com.zyq.service;

import com.zyq.pojo.Payment;

/**
 * 作者：张翼麒
 * Date:2020-6-10
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
