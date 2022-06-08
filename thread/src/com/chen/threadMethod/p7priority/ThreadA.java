package com.chen.threadMethod.p7priority;

/**
 * 陈宇超
 * 18:37
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("thread a : " + (end - begin));
    }
}
