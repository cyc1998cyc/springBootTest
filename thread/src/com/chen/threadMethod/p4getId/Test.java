package com.chen.threadMethod.p4getId;

/**
 * 陈宇超
 * 18:09
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("thread name : " + Thread.currentThread().getName() + ".id = " + Thread.currentThread().getId());

        for (int i = 0; i < 5; i++) {
            new SubThread5().start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
