package com.cj.springcloud.service.serviceImpl;

import com.cj.springcloud.dao.PaymentDao;
import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;
import com.cj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Value("${server.port}")
    private String port;

    @Override
    public CommonResult<Integer> create(Payment payment) {
        log.info(payment.toString());
        int result = paymentDao.create(payment);
        if (result == 0) {
            return new CommonResult<Integer>(444, "fail:" + port, result);
        } else {
            return new CommonResult<Integer>(200, "success:" + port, result);
        }
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        Payment result = paymentDao.getPaymentById(id);
        if (result == null) {
            return new CommonResult<Payment>(444, "fail:" + port, null);
        } else {
            return new CommonResult<Payment>(200, "success:" + port, result);
        }
    }
}
