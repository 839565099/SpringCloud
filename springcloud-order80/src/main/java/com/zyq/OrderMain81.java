package com.zyq;

import com.myrule.MySelfRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 作者：张翼麒
 * Date:2020-6-11
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com")
@RibbonClient(name = "SPRINGCLOUD-PAYMENT-SERVICE",configuration = MySelfRibbonRule.class)
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class, args);
    }
}
