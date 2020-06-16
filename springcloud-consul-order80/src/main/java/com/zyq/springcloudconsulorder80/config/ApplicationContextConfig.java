package com.zyq.springcloudconsulorder80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 作者：张翼麒
 * Date:2020-6-11
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   //使用该注解赋予RestTemplate负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
