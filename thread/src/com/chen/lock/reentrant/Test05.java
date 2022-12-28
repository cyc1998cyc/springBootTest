package com.chen.lock.reentrant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 陈宇超
 * 21:22
 */
public class Test05 {
    static class Service{
        private Lock lock = new ReentrantLock();

        public void serviceMethod(){
            try {
                //lock.lock();
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"-- begin lock!");
                //执行一段耗时的操作
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    new StringBuilder();
                }

                System.out.println(Thread.currentThread().getName()+"-- end lock!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放锁");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        Thread.sleep(50);

        Thread t2 = new Thread(r);
        t2.start();

        Thread.sleep(50);
        t2.interrupt();

        List<Object> objectList = Collections.synchronizedList(new ArrayList<>());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("jiansheng");
            }
        });


        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("123");


    }
}
