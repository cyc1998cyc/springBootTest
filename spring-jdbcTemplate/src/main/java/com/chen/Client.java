package com.chen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.chen");
        /*UserService userService = annotationConfigApplicationContext.getBean(UserService.class);
        User user = userService.selectById(22);
        System.out.println(user);*/

    }
}
