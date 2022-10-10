package com.chen.spring.api;

/**
 * 陈宇超
 * 22:38
 */
public interface BeanFactory {
    /**
     * 通过名字获取bean
     * @param name
     * @return
     */
    Object getBean(String name);
}
