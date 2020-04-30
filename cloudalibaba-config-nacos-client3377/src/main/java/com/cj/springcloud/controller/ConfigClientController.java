package com.cj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo1(){
        return configInfo;
    }

    @Value("${a.b}")
    private String ab;

    @GetMapping("/config/info/ab")
    public String getConfigInfo2(){
        return ab;
    }

}
