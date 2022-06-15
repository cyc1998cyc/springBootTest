package com.chen.threadSafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程的原子性
 * 陈宇超
 * 17:36
 */
public class Test01 {
    public static void main(String[] args) {

        MyInt myInt = new MyInt();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName() + "->" + myInt.getInt());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    static class MyInt{
        //int num;
        AtomicInteger num = new AtomicInteger();
        public int getInt(){
            return num.getAndIncrement();
        }
    }


}
