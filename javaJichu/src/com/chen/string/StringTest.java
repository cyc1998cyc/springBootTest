package com.chen.string;

/**
 * 陈宇超
 * 23:25
 */
public class StringTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("123");
        System.out.println(stringBuilder.length());
        stringBuilder.append("1").append("1").append("213");
        System.out.println(stringBuilder);


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("123").append("abc");
        stringBuffer.insert(1, "陈宇超");
        System.out.println(stringBuffer);
    }
}
