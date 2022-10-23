package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @RequestMapping("/chen")
    @ResponseBody
    public String HelloTest(){
        System.out.println("12312312312312");
        return "";
    }
}
