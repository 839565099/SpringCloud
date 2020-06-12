package com.zyq.pojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 作者：张翼麒
 * Date:2020-6-12
 */
@SpringBootApplication(scanBasePackages = "com")
public class ApiMain {
    public static void main(String[] args) {
        SpringApplication.run(ApiMain.class, args);
    }

}
