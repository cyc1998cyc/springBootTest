package com.chen.threadMethod;

/**
 * 陈宇超
 * 16:12
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        subThread2 subThread2 = new subThread2();
        //设置线程名称
        subThread2.setName("t2");

        subThread2.start();

        Thread.sleep(500);

        Thread thread = new Thread(subThread2);
        thread.start();
    }
}
