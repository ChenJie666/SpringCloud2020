package com.cj.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.cj.springcloud.alibaba.dao")
public class MybatisConfig {
}
