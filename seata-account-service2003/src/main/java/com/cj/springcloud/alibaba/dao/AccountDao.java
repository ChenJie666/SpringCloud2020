package com.cj.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {

    void descrese(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
