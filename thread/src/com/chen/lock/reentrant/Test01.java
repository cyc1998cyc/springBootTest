package com.chen.lock.reentrant;

/**
 * 陈宇超
 * 19:28
 */
public class Test01 {
    public synchronized void sm1(){
        System.out.println("方法1");
        sm2();
    }

    private synchronized void sm2() {
        System.out.println("方法2");
        sm3();
    }

    private synchronized void sm3() {
        System.out.println("方法3");
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.sm1();
            }
        }).start();
    }
}
