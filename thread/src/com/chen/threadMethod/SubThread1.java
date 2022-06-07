package com.chen.threadMethod;

/**
 * 陈宇超
 * 15:58
 */
public class SubThread1 extends Thread{
    public SubThread1() {
        System.out.println("构造方法答应当前方法的线程的名称：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法打印当前线程的名称:" + Thread.currentThread().getName());
    }
}
