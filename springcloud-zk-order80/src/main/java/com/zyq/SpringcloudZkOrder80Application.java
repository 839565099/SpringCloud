package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudZkOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZkOrder80Application.class, args);
    }

}
