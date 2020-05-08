package com.cj.springcloud.alibaba.controller;

import com.cj.springcloud.alibaba.entities.Order;
import com.cj.springcloud.alibaba.service.OrderService;
import com.cj.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功");
    }

}
