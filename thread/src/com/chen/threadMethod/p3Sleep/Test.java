package com.chen.threadMethod.p3Sleep;

/**
 * 陈宇超
 * 17:49
 */
public class Test {
    public static void main(String[] args) {
        SubThread4 t4 = new SubThread4();
        System.out.println("main begin = " + System.currentTimeMillis());
        t4.start();
        System.out.println("main begin = " + System.currentTimeMillis());

    }
}
