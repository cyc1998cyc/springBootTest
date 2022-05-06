package com.chen.annotation;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.lang.annotation.*;

@MyAnnotation
public class Test02 {
    public static void main(String[] args) {

    }

    @MyAnnotation
    public void test(){

    }

}

@Inherited //表示子类可以继承父类的注解
@Documented //表示是否将注解生成在javaDoc中
@Retention(value = RetentionPolicy.RUNTIME)//表示注解在什么地方还有效，比如在源码时，运行是还有效
@Target(value = {ElementType.METHOD,ElementType.TYPE})//定义注解的范围
@interface MyAnnotation{

}