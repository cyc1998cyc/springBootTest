package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 陈宇超
 * 10:26
 */

public class TestIoc {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestIoc.class);
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        C c = context.getBean(C.class);
        LOGGER.info("c=[{}]", c);
    }
}
