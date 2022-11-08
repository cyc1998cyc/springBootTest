package com.chen.consul.controller;

import com.chen.consul.domain.Goods;
import com.chen.consul.service.GoodsService;
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
    public Goods findById(@PathVariable("id") int id){
        Goods goods = goodsService.findById(id);
        System.out.println(goods);
        return goods;
    }
}
