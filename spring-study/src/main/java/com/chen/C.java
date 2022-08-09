package com.chen;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 陈宇超
 * 17:06
 */
public class C implements BeanNameAware {
    private String name;

    public void printName(){
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String s) {
        this.name = name;
    }
}
