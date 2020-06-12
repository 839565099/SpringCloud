package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudPayment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudPayment8002Application.class, args);
    }

}
