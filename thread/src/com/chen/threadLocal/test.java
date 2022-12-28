package com.chen.threadLocal;

/**
 * 陈宇超
 * 17:28
 */
public class test {
    //定义threadlocal对象
    static ThreadLocal threadLocal = new ThreadLocal();

    //定义线程类
    static class SubThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                //设置线程关联的值
                threadLocal.set(Thread.currentThread().getName()+"-"+i);

                //调用get()方法读取关联的值
                System.out.println(Thread.currentThread().getName()+" value = "+threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        SubThread t2 = new SubThread();

        t1.start();
        t2.start();
    }
}
