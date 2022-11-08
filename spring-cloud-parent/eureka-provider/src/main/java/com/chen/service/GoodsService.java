package com.chen.service;

import com.chen.dao.GoodsDao;
import com.chen.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 陈宇超
 * 1:15
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public Goods findById(Integer id){
        return goodsDao.findById(id);

    }
}
