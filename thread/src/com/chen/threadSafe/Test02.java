package com.chen.threadSafe;

import java.util.Random;

/**
 * 测试线程的可见性
 * 陈宇超
 * 17:53
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        new Thread(myTask).start();

        Thread.sleep(1000);

        myTask.cancel();
    }

    static class MyTask implements Runnable{
        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel){
                if (doSomething()){
                    break;
                }
            }

            if (toCancel){
                System.out.println("任务被取消");
            }else{
                System.out.println("任务正常结束");
            }
        }

        private boolean doSomething(){
            System.out.println("执行某个任务");
            //模拟执行任务的时间
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return true;
        }

        public void cancel(){
            toCancel = true;
            System.out.println("收到 取消线程的消息");
        }
    }
}
