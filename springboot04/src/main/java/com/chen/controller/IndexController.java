package com.chen.controller;

import com.chen.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    /*@RequestMapping({"/","/index.html"})
    public String Index(){
        return "index";
    }*/

    @RequestMapping("/getJson")
    @ResponseBody
    public void getJson(@RequestBody String string){
        System.out.println(string);
    }
}
