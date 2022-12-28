package com.chen.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 陈宇超
 * 19:03
 * 在多线程环境中，将字符串转化为日期对象
 */
public class Test02 {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    //定义runnable接口实现类
    static class ParseDate implements Runnable{

        private  int i = 0;

        public ParseDate(int i){
            this.i = i;
        }
        @Override
        public void run() {
            String text = "2366年11月12日 08:55:" + i%60;
            //先判断线程是否有SimpleDateFormat对象,如果当前线程没有就创建一个
            if (threadLocal.get() == null){
                threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
            }
            try {
                Date date = threadLocal.get().parse(text);
                System.out.println(i+ " "+date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //创建100个线程
        for (int i = 0; i < 100; i++) {
            new Thread(new ParseDate(i)).start();
        }
    }
}
