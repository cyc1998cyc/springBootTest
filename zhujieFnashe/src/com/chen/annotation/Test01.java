package com.chen.annotation;


import java.util.ArrayList;
import java.util.List;

/**
 * 内置注解
 */
public class Test01 extends Object{
    public static void main(String[] args) {
        System.out.println(new Test01().test());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 此注解表示已过时,不推荐程序员使用，但是可以使用
     * @return
     */
    @Deprecated
    public String test(){
        return "已废弃";
    }


    /**
     * 此注解表示镇压警告
     */
    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }
}
