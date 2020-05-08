package com.cj.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cj.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;

public class CustomerBlockHandler {
    public static CommonResult handlerException(@PathVariable Long id,BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException-----1");
    }

    public static CommonResult handlerException2(@PathVariable Long id,BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException-----2");
    }
}
