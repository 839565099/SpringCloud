package com.zyq.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
//==================服务降级====================

    /**
     * 模拟正常调用无延迟
     *
     * @param id
     * @return
     */
    public String paymentinfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "  payment_OKID:  " + id + "\t" + "哈哈哈😂";
    }


    /**
     * 模拟需要处理6秒钟，3秒为正常
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentinfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "13000")//3 秒 钟 以 内 就是正常的 业务逻辑
    })
    public String paymentinfo_timeOut(Integer id) {
        int time = 6;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "  timeOut_ID:  " + id + "\t" + "呜呜呜😭,耗时： " + time;
    }

    /**
     * paymentinfo_timeOut出事之后有一个兜底的
     *
     * @param id
     * @return
     */
    public String paymentinfo_timeOutHandler(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "  timeOut_ID:  " + id + "\t" + "8001系统忙，稍后再试，兜底～～～～";

    }

    //==================服务熔断====================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),   // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id  不能负数 ");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " \t " + " 调用成功 , 流水号： " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id  不能负数，请稍候再试 ,(┬ ＿ ┬)/~~     id: " + id;
    }


}
