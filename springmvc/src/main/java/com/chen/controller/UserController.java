package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/hello2")
    public String handleRequest(Model model) throws Exception {
        model.addAttribute("msg","1812244d");
        System.out.println("1812244d");
        return "redirect:https://www.baidu.com";
    }
}
