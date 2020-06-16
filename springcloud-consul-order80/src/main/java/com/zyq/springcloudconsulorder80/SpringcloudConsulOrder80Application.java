package com.zyq.springcloudconsulorder80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudConsulOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsulOrder80Application.class, args);
    }

}
