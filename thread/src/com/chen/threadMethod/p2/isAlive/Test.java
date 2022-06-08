package com.chen.threadMethod.p2.isAlive;

/**
 * 陈宇超
 * 17:43
 */
public class Test {
    public static void main(String[] args) {
        SubThread3 t3 = new SubThread3();
        System.out.println("begin t3 is alive:" + t3.isAlive());
        t3.start();
        System.out.println("end t3 is alive:" + t3.isAlive());

    }
}
