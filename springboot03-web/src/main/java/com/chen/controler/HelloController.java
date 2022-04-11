package com.chen.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 陈宇超
 * 17:46
 */
//如果是返回静态资源只能使用Controller
//这个需要模板引擎的支持
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/index")
    public String index(){
        return "/index";
    }
}
