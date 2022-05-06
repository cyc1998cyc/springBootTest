package com.chen.reflection;

import java.lang.annotation.ElementType;

public class Test03 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String.class;
        Class c4 = Override.class;
        Class c5 = ElementType.class;
        final Class<Class> classClass = Class.class;
        System.out.println(classClass);

    }
}
