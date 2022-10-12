package com.chen.client;

import com.chen.spring.api.impl.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.properties");
        Object bean = classPathXmlApplicationContext.getBean("d");
        System.out.println(bean);
    }
}
