package com.chen;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * 陈宇超
 * 23:39
 */
public class MyTest {

    public static final Logger LOGGER = Logger.getLogger(MyTest.class.getName());


    @Test
    public void logTest() throws IOException {
        //去掉默认配置
        LOGGER.setUseParentHandlers(false);

        //能不能添加我想要的handlers

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        consoleHandler.setLevel(Level.ALL);

        //构建一个filehandler
        FileHandler fileHandler = new FileHandler("D://logTest/test.log",true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.ALL);


        LOGGER.setLevel(Level.ALL);

        LOGGER.addHandler(consoleHandler);
        LOGGER.addHandler(fileHandler);

        //十分严重的
        LOGGER.severe("severe");
        //警告
        LOGGER.warning("warning");
        //info 默认级别
        LOGGER.info("info");
        //fine
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");
    }

    @Test
    public void testParent(){
        //任何名字相同的 logger 都是单例的，名字相同的至于一个
        Logger LOGGER01 = Logger.getLogger(MyTest.class.getName());
        Logger LOGGER02 = Logger.getLogger("com.chen");
        System.out.println(LOGGER01 == LOGGER);

        System.out.println(LOGGER.getParent().getName());
        System.out.println(LOGGER02.getParent().getName());
    }

    @Test
    public void testFormatter(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getSourceClassName() + record.getMessage();
            }
        });
        consoleHandler.setLevel(Level.ALL);




        LOGGER.setLevel(Level.ALL);

        LOGGER.addHandler(consoleHandler);

        //十分严重的
        LOGGER.severe("severe");
        //警告
        LOGGER.warning("warning");
        //info 默认级别
        LOGGER.info("info");
        //fine
        LOGGER.fine("fine");
        LOGGER.finer("finer");
        LOGGER.finest("finest");
    }
}
