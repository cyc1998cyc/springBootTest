package com.chen.spring.api;

/**
 * 陈宇超
 * 22:37
 */
public interface BeanPostProcessor {
    void beforeInitialIzation(Object bean);

    void afterInitialIzation(Object bean);

}
