package com.chen.threadMethod.p8interrupt;

/**
 * 陈宇超
 * 14:16
 */
public class Test {
    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main ==>" + i);
        }

        t1.interrupt();


    }
}
