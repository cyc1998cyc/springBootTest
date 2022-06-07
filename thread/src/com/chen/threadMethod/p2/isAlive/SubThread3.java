package com.chen.threadMethod.p2.isAlive;

/**
 * 陈宇超
 * 17:05
 */
public class SubThread3 extends Thread{
    @Override
    public void run() {
        System.out.println("run方法，isAlive = " + this.isAlive());
    }
}
