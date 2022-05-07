package com.chen.day02;

/**
 * 陈宇超
 * 15:16
 */
public class Test {
    public static void main(String[] args) {

        print32(-1);
        //System.out.println("**************************");

        //&:与运算：只有两个1相遇结果才会是1其余全是0
        //System.out.println(123);
        //System.out.println(123 >> 1);


    }

    //定义一个将int类型的 转义成32位信息的方法
    public static void print32(int num){
        for (int i = 31; i >= 0 ; i--) {
            System.out.print((num&(1 << i)) == 0 ? "0":"1");
        }
        System.out.println();
    }
}
