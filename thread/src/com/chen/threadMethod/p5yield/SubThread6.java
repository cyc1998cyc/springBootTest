package com.chen.threadMethod.p5yield;

/**
 * Thread.yield() 表示放弃当前cpu资源
 * 陈宇超
 * 18:18
 */
public class SubThread6 extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum+=i;
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end-begin));
    }
}
