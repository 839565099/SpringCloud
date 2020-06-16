package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：张翼麒
 * Date:2020-6-14
 */
@Configuration
public class MySelfRibbonRule {
//    @Bean
    public IRule myRule(){
        /**
         * 定义Ribbon随意负载均衡规则
         */
        return new RandomRule();
    }
}
