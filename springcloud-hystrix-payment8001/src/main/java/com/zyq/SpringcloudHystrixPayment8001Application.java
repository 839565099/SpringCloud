package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringcloudHystrixPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixPayment8001Application.class, args);
    }

}
