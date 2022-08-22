package com.chen;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 陈宇超
 * 10:36
 */
public class TestAnnotation {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        Boy boy = context.getBean(Boy.class);
    }
}
