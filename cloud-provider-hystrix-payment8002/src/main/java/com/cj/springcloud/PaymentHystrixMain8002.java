package com.cj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class PaymentHystrixMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8002.class,args);
    }
}
