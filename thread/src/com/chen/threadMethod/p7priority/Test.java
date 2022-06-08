package com.chen.threadMethod.p7priority;

/**
 * 陈宇超
 * 18:36
 */
public class Test {
    public static void main(String[] args) {
        ThreadA tA = new ThreadA();
        tA.setPriority(10);
        tA.start();

        ThreadB tB = new ThreadB();
        tB.setPriority(1);
        tB.start();


    }
}
