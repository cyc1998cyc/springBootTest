package com.chen.threadMethod;

/**
 * 陈宇超
 * 16:04
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("main方法中打印当前线程名称" + Thread.currentThread().getName());

    //    创建子线程
        SubThread1 subThread1 = new SubThread1();
        subThread1.start();


    }
}
