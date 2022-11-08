package com.chen.consumer.feign;

import com.chen.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 陈宇超
 * 20:51
 */

@FeignClient("EUREKA-PROVIDER")
public interface GoodsFeign {

    @GetMapping("/goods/findById/{id}")
    Goods findById(@PathVariable("id") Integer id);
}
