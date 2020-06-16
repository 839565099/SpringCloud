package com.zyq.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者：张翼麒
 * Date:2020-6-14
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances) {
        //使用当前访问是第几次 % 当前这个服务名下对应实际微服务数 的余数来确定此次访问哪个微服务实现负载均衡
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    public final int getAndIncrement(){
        int current;
        int next;
        while (true){
            current = this.atomicInteger.get();
            next=current>=2147483647? 0 :current+1;
            //下面使用CAS自旋锁，防止多线程情况下，current当前次数不一致的情况
            //就是在改变的那一时刻在去比较current和期望的相同不，没有被其他线程改变过，确认相同才把next的新值赋给current
            if (this.atomicInteger.compareAndSet(current,next)){
                System.out.println("~~~~~~~~ next:"+next);
                return next;
            }

        }
    }
}
