package com.chen.threadMethod.p9daemon;

/**
 * 设置线程为守护线程
 * 陈宇超
 * 14:32
 */
public class Test {
    public static void main(String[] args) {
        SubDaemonThread subDaemonThread = new SubDaemonThread();
        //subDaemonThread.setDaemon(true);
        subDaemonThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main==>");
        }
    }
}
