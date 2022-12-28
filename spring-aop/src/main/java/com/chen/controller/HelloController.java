package com.chen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 陈宇超
 * 13:55
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "hello"+name;
    }


}
