package com.zyq.serviceImp;

import com.zyq.mapper.PaymentMapper;
import com.zyq.pojo.Payment;
import com.zyq.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 作者：张翼麒
 * Date:2020-6-10
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentMapper mapper;

    @Override
    public int create(Payment payment) {
        return mapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return mapper.getPaymentById(id);
    }
}
