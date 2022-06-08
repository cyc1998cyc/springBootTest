package com.chen.threadMethod.p5yield;

/**
 * 陈宇超
 * 18:17
 */
public class Test {
    public static void main(String[] args) {

        SubThread6 t6 = new SubThread6();
        t6.start();

        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main方法用时：" + (end-begin));
    }
}
