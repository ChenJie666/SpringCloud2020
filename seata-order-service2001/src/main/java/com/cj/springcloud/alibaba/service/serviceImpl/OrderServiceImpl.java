package com.cj.springcloud.alibaba.service.serviceImpl;

import com.cj.springcloud.alibaba.dao.OrderDao;
import com.cj.springcloud.alibaba.entities.Order;
import com.cj.springcloud.alibaba.service.AccountService;
import com.cj.springcloud.alibaba.service.OrderService;
import com.cj.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional/*(name="my_test_tx_group",rollbackFor=Exception.class)*/
    public void createOrder(Order order) {
        //创建订单
        log.info("----->开始创建订单");
        orderDao.create(order);
        //库存扣除
        log.info("----->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减END");
        //余额扣除
        log.info("----->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减END");

        //修改订单状态，从0到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态END");

        log.info("----->订单创建结束，o(0_0)o");
    }

}
