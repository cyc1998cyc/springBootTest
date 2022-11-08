package com.chen.controller;

import com.chen.domain.Goods;
import com.chen.service.GoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 陈宇超
 * 1:17
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("findById/{id}")
    @HystrixCommand(fallbackMethod = "findById_fallback")
    public Goods findById(@PathVariable("id") int id){
        Goods goods = goodsService.findById(id);
        System.out.println(goods);

        //模拟出异常
        int i = 1/0;

        return goods;
    }

    /**
     * 定义一个降级方法
     * 1 方法的返回值要和原来一致
     * 2 方法的参数要和原方法一样
     */
    public Goods findById_fallback(Integer id){
        Goods goods = new Goods();
        goods.setGoodsId(-1);
        goods.setTitle("provider提供方法降级");
        goods.setPrice(-9.9);
        goods.setStock(-10);
        return goods;

    }
}
