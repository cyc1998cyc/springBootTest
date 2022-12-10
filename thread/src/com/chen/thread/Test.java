package com.chen.thread;

/**
 * 陈宇超
 * 15:25
 */
public class Test {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        System.out.println(threadTest.getId());
        threadTest.interrupt();
        threadTest.isInterrupted();


    }
}

class ThreadTest extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
