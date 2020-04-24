package com.cj.springlcoud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    @Value(value = "${server.port}")
    private String port;

    public String paymentInfo_OK(Integer id) {
        return "port:" + port + "    线程池： " + Thread.currentThread().getName()+"   paymentInfo_OK,id  " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int i = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "port:" + port + "    线程池： " + Thread.currentThread().getName()+"   paymentInfo_timeout,id  " + id;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "port:" + port + "    线程池： " + Thread.currentThread().getName()+"  系统繁忙或出现异常,id  " + id;
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            //查看HystrixCommandProperties查看可以设置的属性
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期后断路器状态置为半开放接收一条请求
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//请求次数中失败次数达到百分之60后熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //返回不带"-"号的UUID

        return "port:" + port + "    线程池： " + Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "port:" + port + "    线程池： " + Thread.currentThread().getName()+"  配置熔断器的服务繁忙或出现异常,id  " + id;
    }

}
