package com.chen;

import org.apache.log4j.*;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 陈宇超
 * 0:45
 */
public class TestLog4j {
    Logger logger = Logger.getLogger(TestLog4j.class);
    @Test
    public void testLog4j(){

        //这行代码 给 logger 加了一个默认的配置 输出到控制台
        BasicConfigurator.configure();


        logger.info("test log4j!");
    }

    @Test
    public void testLog4j2() throws IOException {
        //控制台
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setName("chen");
        consoleAppender.setWriter(new PrintWriter(System.out));

        //文件
        FileAppender fileAppender = new FileAppender();
        fileAppender.setWriter(new FileWriter(new File("D:\\logTest\\test.log")));
        fileAppender.setFile("D:\\logTest\\test.log");
        fileAppender.setName("chen");


        //consoleAppender.setLayout(layout);
        consoleAppender.setLayout(new PatternLayout("%-d{yyyy-MM-dd HH:mm:ss} [%t:%r] -[%p] %m%n"));
        fileAppender.setLayout(new PatternLayout("%-d{yyyy-MM-dd HH:mm:ss} [%t:%r] -[%p] %m%n"));


        logger.addAppender(consoleAppender);
        logger.addAppender(fileAppender);

        logger.info("testLog4j2");
    }

    @Test
    public void testLog4j3(){
        JDBCAppender jdbcAppender = new JDBCAppender();
        jdbcAppender.setDriver("com.mysql.cj.jdbc.Driver");
        jdbcAppender.setURL("jdbc:mysql://localhost:3306/ssm?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        jdbcAppender.setUser("root");
        jdbcAppender.setPassword("1812244d");
        jdbcAppender.setSql("INSERT INTO log(project_name,create_date,level,category,file_name,thread_name,line,all_category,message) values('chen','%d{yyyy-MM-ddHH:mm:ss}','%p','%c','%F','%t','%L','%l','%m')");

        logger.addAppender(jdbcAppender);
        logger.info("testLog4j3");

    }
    @Test
    public void testLog4j4(){
        logger.info("chenyuchao");
    }


}
