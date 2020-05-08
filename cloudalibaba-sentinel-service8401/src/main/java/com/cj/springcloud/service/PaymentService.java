package com.cj.springcloud.service;

import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class) //fallback方法进行兜底
public interface PaymentService {

    @GetMapping(value = "/payment/nacos/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}
