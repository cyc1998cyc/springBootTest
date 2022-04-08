package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication标注这个类是springboot程序
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        //将springboot启动
        SpringApplication.run(Springboot01Application.class, args);
    }

}
