package com.chen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {

    @MyAnnotation2(name = "陈宇超",age = 18)
    public void test(){

    }

    @MyAnnotation3("123")
    public void test2(){

    }
}

@Target({ElementType.TYPE,ElementType.METHOD})//可以定义在类上和方法上
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名();
    String name() default "";
    int age() default 0;
    int id () default -1;//如果默认值为-1 表示不存在,indexof,如果找不到就返回-1

    String[] schools() default {"清华大学"};
}


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value() default "";
}
