package com.chen.provider.controller;

import com.chen.provider.domain.Goods;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 陈宇超
 * 7:40
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


    @GetMapping("findById/{id}")
    @HystrixCommand(fallbackMethod = "findById_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public Goods findById(@PathVariable("id") int id) throws InterruptedException {
        Goods goods = new Goods();
        goods.setId("chenyuchao");
        return goods;
    }

    //定义降级方法
    public Goods findById_fallback(int id) {
        Goods goods = new Goods();
        goods.setId("-1");
        return goods;
    }
}