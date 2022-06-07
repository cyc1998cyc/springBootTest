package com.chen.thread;

/**
 * 陈宇超
 * 15:24
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("子线程打印的内容");
    }
}
