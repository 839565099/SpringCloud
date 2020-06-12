package com.zyq.serviceImp;

import com.zyq.mapper.PaymentMapper;
import com.zyq.pojo.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 作者：张翼麒
 * Date:2020-6-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceImplTest {
    @Resource
    PaymentMapper mapper;

    @Test
    public void T1() {
        Payment payment = mapper.getPaymentById((long) 1);
        System.out.println(payment);
    }

    @Test
    public void T2() {
        Payment payment = new Payment((long) 4, "aaaa");
        int i = mapper.create(payment);
        System.out.println(i);

    }

}