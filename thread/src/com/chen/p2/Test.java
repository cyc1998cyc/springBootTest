package com.chen.p2;

/**
 * 陈宇超
 * 15:37
 */
public class Test {
    public static void main(String[] args) {
        myThread2 myThread2 = new myThread2();
        myThread2.start();


        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("main:" + i);
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
