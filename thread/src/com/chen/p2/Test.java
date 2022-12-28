package com.chen.p2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 陈宇超
 * 15:37
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        Thread thread = new Thread(futureTask);
        thread.start();

        String s = futureTask.get();
        System.out.println(s);


    }
}

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println();
        return Thread.currentThread().getName();
    }
}
