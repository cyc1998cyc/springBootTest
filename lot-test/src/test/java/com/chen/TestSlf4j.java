package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 陈宇超
 * 16:34
 */
public class TestSlf4j {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestSlf4j.class);

    @Test
    public void testLog(){
        LOGGER.info("123");

        String name = "wang";
        int age = 18;
        LOGGER.info("{}今年{}岁了",name,age);

        try {
            int i = 1/0;
        } catch (Exception e) {
            //e.printStackTrace();
            LOGGER.error("出现异常", e);
        }
    }
}
