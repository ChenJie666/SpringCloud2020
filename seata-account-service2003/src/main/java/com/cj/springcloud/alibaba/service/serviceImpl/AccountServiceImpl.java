package com.cj.springcloud.alibaba.service.serviceImpl;

import com.cj.springcloud.alibaba.dao.AccountDao;
import com.cj.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----->account-service中扣减账户余额开始");
        accountDao.descrese(userId,money);
        log.info("----->account-service中扣减账户余额END");
    }
}
