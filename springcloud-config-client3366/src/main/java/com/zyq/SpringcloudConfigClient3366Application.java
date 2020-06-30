package com.zyq;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudConfigClient3366Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigClient3366Application.class, args);
    }

}
