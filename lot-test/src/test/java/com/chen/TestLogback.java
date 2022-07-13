package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 陈宇超
 * 18:36
 */
public class TestLogback {
    private final static Logger logger = LoggerFactory.getLogger(TestLogback.class);
    @Test
    public void testLogback1(){
        logger.info("123");

    }
}
