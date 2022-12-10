package com.chen.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 陈宇超
 * 0:48
 */
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("xiancheng");
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        MyRunnable myRunnable = new MyRunnable();

        pool.submit(myRunnable);


    }
}
