package com.cj.springcloud.service.serviceImpl;

import com.cj.springcloud.dao.PaymentDao;
import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;
import com.cj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentDao.create(paymentDao);
        if(result == 0){
            return new CommonResult<Integer>(444, "failed", result);
        }else {
            return new CommonResult<Integer>(200, "sucessed", result);
        }
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        Payment result = paymentDao.getPaymentById(id);
        if(result == null){
            return new CommonResult<Payment>(444,"failed",null);
        }else{
            return new CommonResult<Payment>(200,"success",result);
        }
    }
}
