package com.chen.threadMethod.p3Sleep;

/**
 * 子线程休眠
 * 陈宇超
 * 17:49
 */
public class SubThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("run,threadName=" + Thread.currentThread().getName() + ",begin=" + System.currentTimeMillis());
        try {
            Thread.sleep(2000);//当前线程睡眠2000毫秒
        } catch (InterruptedException e) {
            //在子线程的run方法中 产生异常时，只能捕获异常
            e.printStackTrace();
        }
        System.out.println("run,threadName=" + Thread.currentThread().getName() + ",begin=" + System.currentTimeMillis());
    }
}
