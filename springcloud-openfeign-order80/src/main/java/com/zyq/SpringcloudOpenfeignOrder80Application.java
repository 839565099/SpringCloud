package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringcloudOpenfeignOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOpenfeignOrder80Application.class, args);
    }

}
