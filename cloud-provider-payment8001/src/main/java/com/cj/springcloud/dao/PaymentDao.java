package com.cj.springcloud.dao;

import com.cj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PaymentDao {

    int create(PaymentDao paymentDao);

    Payment getPaymentById(@Param("id") Long id);

}
