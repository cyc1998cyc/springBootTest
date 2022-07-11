package com.chen;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;

import java.io.PrintWriter;

/**
 * 陈宇超
 * 0:45
 */
public class testLog4j {
    private static final Logger LOGGER = Logger.getLogger(testLog4j.class);
    @Test
    public void testLog4j(){
        //BasicConfigurator.configure();




        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setWriter(new PrintWriter(System.out));

        PatternLayout patternLayout = new PatternLayout("%d %l %m%n");
        consoleAppender.setLayout(patternLayout);

        //将日志保存到数据库
        /*JDBCAppender jdbcAppender = new JDBCAppender();
        jdbcAppender.setSql();
        jdbcAppender.setUser();
        jdbcAppender.setPassword();
        jdbcAppender.setDriver();
        jdbcAppender.setURL();*/


        LOGGER.addAppender(new MyAppender());


        LOGGER.info("hello");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");

        System.out.println("jiansheng");

    }
}
