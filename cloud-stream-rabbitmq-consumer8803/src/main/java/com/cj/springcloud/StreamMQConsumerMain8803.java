package com.cj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8803.class, args);
    }
}
