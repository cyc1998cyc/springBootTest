package com.chen.client;

import com.chen.spring.api.ApplicationContext;
import com.chen.spring.api.ApplicationContextAware;
import com.chen.spring.api.BeanFactoryPostProcessor;
import com.chen.spring.api.BeanPostProcessor;

import java.util.concurrent.ConcurrentHashMap;

public class D implements ApplicationContextAware , BeanFactoryPostProcessor, BeanPostProcessor {

    public D() {
        System.out.println("D is created!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println(applicationContext+ "---------------------------setApplicationContext");
    }

    @Override
    public void BeanFactoryPostProcess(ConcurrentHashMap concurrentHashMap) {
        System.out.println(concurrentHashMap+ "---------------------------BeanFactoryPostProcess");
    }

    @Override
    public void beforeInitialIzation(Object bean) {
        System.out.println(bean+ "---------------------------beforeInitialIzation");
    }

    @Override
    public void afterInitialIzation(Object bean) {
        System.out.println(bean+ "---------------------------afterInitialIzation");
    }
}
