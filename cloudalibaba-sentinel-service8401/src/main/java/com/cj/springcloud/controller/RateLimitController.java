package com.cj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cj.springcloud.entities.CommonResult;
import com.cj.springcloud.entities.Payment;
import com.cj.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource/{id}")
    @SentinelResource(value = "byResource",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException",
            fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult byResource(@PathVariable Long id) {
        if (id == 4) {
            throw new RuntimeException("代码异常");
        } else if (id > 4) {
            throw new IllegalArgumentException("参数异常");
        }
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(id, "serial001"));
    }

    public CommonResult handlerException(@PathVariable Long id, BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "fallback异常内容：" + e.getMessage(), payment);
    }

}
