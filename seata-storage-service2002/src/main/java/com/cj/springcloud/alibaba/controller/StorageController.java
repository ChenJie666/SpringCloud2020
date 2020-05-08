package com.cj.springcloud.alibaba.controller;

import com.cj.springcloud.alibaba.service.StorageService;
import com.cj.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }

}
