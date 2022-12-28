package com.chen.consumer.controller;

import com.chen.consumer.domain.Goods;
import com.chen.consumer.feign.GoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 陈宇超
 * 7:44
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private GoodsFeign goodsFeign;


    @GetMapping("/add/{id}")
    public Goods add(@PathVariable("id") Integer id){
        //业务逻辑
        //1查询商品
        //2减库存
        //3支付
        //4物流

        return goodsFeign.findById(id);
    }
}
