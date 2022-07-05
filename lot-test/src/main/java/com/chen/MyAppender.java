package com.chen;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * 陈宇超
 * 1:17
 */
public class MyAppender extends AppenderSkeleton {
    protected void append(LoggingEvent loggingEvent) {
        //能不能使用jdbc去输出
        System.out.println("from myAppender---" + loggingEvent.getMessage());
    }

    public void close() {

    }

    public boolean requiresLayout() {
        return false;
    }
}
