package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogbact {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogbact.class);

    @Test
    public void testLogback1() {

        /*while (true){

        }*/


        LOGGER.error("++++++++++++++++++++++++++++++++++++++++++");
        LOGGER.warn("++++++++++++++++++++++++++++++++++++++++++");
        LOGGER.info("++++++++++++++++++++++++++++++++++++++++++");
        LOGGER.debug("++++++++++++++++++++++++++++++++++++++++++");
        LOGGER.trace("++++++++++++++++++++++++++++++++++++++++++");
        //打印日志信息

        System.out.println("123123");
        System.out.println("123123");
        System.out.println("123123");
        System.out.println("123123");
        System.out.println("123123");
        System.out.println("123123");
        System.out.println("123123");



    }
}
