package com.zyq.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 作者：张翼麒
 * Date:2020-6-14
 */
public interface LoadBalancer {
    //接口作用：传入当前的注册中心有相同名字的多个微服务集合，调用实现类，最后返回轮询后此次调用哪个
    ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances);
}
