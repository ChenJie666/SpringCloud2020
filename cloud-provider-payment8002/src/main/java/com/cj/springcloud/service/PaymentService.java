package com.cj.springcloud.service;

import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;

public interface PaymentService {

    CommonResult<Integer> create(Payment payment);

    CommonResult<Payment> getPaymentById(Long id);
}
