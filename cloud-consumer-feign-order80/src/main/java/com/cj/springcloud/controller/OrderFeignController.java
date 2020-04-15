package com.cj.springcloud.controller;

import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;
import com.cj.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        log.info(payment.toString());
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/timeoutTest")
    public CommonResult<Object> timeoutTest(){
        return paymentFeignService.timeoutTest();
    }
}
