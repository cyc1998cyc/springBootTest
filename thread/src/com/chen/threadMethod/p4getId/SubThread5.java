package com.chen.threadMethod.p4getId;

/**
 * 陈宇超
 * 18:09
 */
public class SubThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName() + ",id = " + Thread.currentThread().getId());

    }
}
