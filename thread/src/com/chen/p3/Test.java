package com.chen.p3;

/**
 * 陈宇超
 * 15:40
 */
public class Test {
    public static void main(String[] args) {
        //1 创建Runnable 接口实现对象
        MyRunnable myRunnable = new MyRunnable();
        //2 创建 Thread 对象，形参为 Runnable 接口实现对象
        Thread myThread = new Thread(myRunnable);
        //3 调用start对象的start方法
        myThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main " + "--"  + i);
        }

        //匿名内部类
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("sub thread2" + "--" + i);
                }
            }
        });

        thread2.start();
    }
}
