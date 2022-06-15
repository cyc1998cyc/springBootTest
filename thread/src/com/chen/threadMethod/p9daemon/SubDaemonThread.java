package com.chen.threadMethod.p9daemon;

/**
 * 陈宇超
 * 15:58
 */
public class SubDaemonThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("subThread");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
