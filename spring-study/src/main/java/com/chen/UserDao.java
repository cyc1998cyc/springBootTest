package com.chen;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserDao {
    public void hello() {
        System.out.println("userDao say hello!");
    }

    @PostConstruct
    public void create(){
        System.out.println("创建");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}
