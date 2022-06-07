package com.chen.thread;

/**
 * 陈宇超
 * 15:25
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("主线程打印的内容");


        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("main线程后面的代码");
    }
}
