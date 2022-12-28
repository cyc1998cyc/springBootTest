package com.chen.consumer.feign;

import com.chen.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 陈宇超
 * 12:16
 */
@FeignClient("EUREKA-PROVIDER")
public interface GoodsFeign {
    @GetMapping("/goods/findById/{id}")
    public Goods findById(@PathVariable("id") Integer id);
}
