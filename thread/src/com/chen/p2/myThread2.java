package com.chen.p2;

/**
 * 陈宇超
 * 15:33
 */
public class myThread2 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread:" + i);
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
