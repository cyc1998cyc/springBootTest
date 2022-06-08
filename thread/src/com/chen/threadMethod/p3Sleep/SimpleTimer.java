package com.chen.threadMethod.p3Sleep;

/**
 * 陈宇超
 * 18:01
 */
public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 60;

        while (true){
            System.out.println("remaining: " + remaining);
            remaining --;
            if (remaining < 0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
