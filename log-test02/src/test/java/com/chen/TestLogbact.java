package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogbact {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogbact.class);
    @Test
    public void testLogback1(){
        //打印日志信息
        while (true){
            LOGGER.error("error");
            LOGGER.warn("warn");
            LOGGER.info("info");
            LOGGER.debug("debug");
            LOGGER.trace("trace");
        }

    }
}
