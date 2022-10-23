package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("/test1")
    @CrossOrigin
    public ModelAndView Test1(){
        int i=10/0;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","asdfasdf0");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
