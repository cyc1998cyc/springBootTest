package com.chen.threadMethod.p8interrupt;

/**
 * 陈宇超
 * 14:17
 */
public class SubThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (this.isInterrupted()){
                break;
            }
            System.out.println("SubThread ==>" + i);
        }
    }
}
