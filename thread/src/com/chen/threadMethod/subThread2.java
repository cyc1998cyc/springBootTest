package com.chen.threadMethod;

/**
 * 陈宇超
 * 16:09
 */
public class subThread2 extends Thread {
    public subThread2() {
        System.out.println("构造方法中Thread.currentThread().getName()：" + Thread.currentThread().getName());
        System.out.println("构造方法中this.getName():" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中Thread.currentThread().getName()：" + Thread.currentThread().getName());
        System.out.println("run方法中this.getName():" + this.getName());
    }
}
