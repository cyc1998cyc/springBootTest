package com.chen.consul.dao;

import com.chen.consul.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * 陈宇超
 * 1:11
 */
@Repository
public class GoodsDao {
    public Goods findById(Integer id){
        //模拟从数据库中查询
        Goods goods = new Goods();
        goods.setGoodsId(id);
        goods.setTitle("手机");
        goods.setPrice(5999D);
        goods.setStock(234);
        return goods;
    }
}
