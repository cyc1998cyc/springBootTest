package com.chen.zk.controller;

import com.chen.zk.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 陈宇超
 * 1:30
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/add/{id}")
    public Goods add(@PathVariable("id") Integer id){
        //String url = "http://localhost:8000/goods/findById/" + id;
        //Goods goods = restTemplate.getForObject(url, Goods.class);

        //服务发现
        List<ServiceInstance> instances = discoveryClient.getInstances("zookeeper-provider");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        System.out.println(host);
        System.out.println(port);
        String url = "http://"+host+":"+port+"/goods/findById/" + id;
        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }

}
