package com.chen.spring.api.impl;

import com.chen.spring.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 陈宇超
 * 22:41
 */
public class ClassPathXmlApplicationContext implements ApplicationContext, Resource {
    /**
     * 创建 beanFactory
     */
    private ConcurrentHashMap<String, Object> beanFactory;



    private ConcurrentHashMap<String, BeanFactoryPostProcessor> beanFactoryPostProcessors = new ConcurrentHashMap<>();


    private ConcurrentHashMap<String, BeanPostProcessor> beanPostProcessors = new ConcurrentHashMap<>();

    /**
     * 生成bean的定义类
     */
    private Properties beanDefinitions = new Properties();

    public ClassPathXmlApplicationContext(String config) {
        InputStream inputStream = readXML(config);
        try {
            //通过配置文件加载bean的定义
            beanDefinitions.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //刷新工厂
        refresh();


    }

    private void refresh() {
        //1.准备环境
        prepareRefresh();

        //2.创建门面
        beanFactory = new ConcurrentHashMap<>();

        //3.设置忽略的一些接口
        //  准备工作
        prepareBeanFactory(beanFactory);

        try {
            //给后来的程序员实现的
            postProcessBeanFactory(beanFactory);

            // bean工厂已经基本好了，后置处理器
            invokeBeanFactoryPostProcessors(beanFactory);

            //注册所有的BeanPostProcessors
            registerBeanPostProcessors(beanFactory);

            //完成实例化
            finishBeanFactoryInitialization(beanFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void postProcessBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {

    }

    private void registerBeanPostProcessors(ConcurrentHashMap<String, Object> beanFactory) {

    }

    private void invokeBeanFactoryPostProcessors(ConcurrentHashMap<String, Object> beanFactory) {
        //1.找到所有的 BeanFactoryPostProcessors
        for(Map.Entry<String,BeanFactoryPostProcessor> entry : beanFactoryPostProcessors.entrySet()){
            //2.调用方法
            entry.getValue().BeanFactoryPostProcess(beanFactory);

        }



    }

    private void finishBeanFactoryInitialization(ConcurrentHashMap<String, Object> beanFactory) {
        for(Map.Entry<Object,Object> entry : beanDefinitions.entrySet()){
            String className = (String) entry.getValue();
            Object bean = null;
            try {
                //1 创建
                Class<?> aClass = Class.forName(className);
                Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                bean = declaredConstructor.newInstance();


                //2 依赖注入 属性填充


                for (Map.Entry<String,BeanPostProcessor> entry1 : beanPostProcessors.entrySet()){
                    entry1.getValue().beforeInitialIzation(bean);
                }

                //3 init(初始化)
                if (aClass.isAssignableFrom(ApplicationContextAware.class)){
                    ApplicationContextAware applicationContextAware = (ApplicationContextAware) bean;
                    applicationContextAware.setApplicationContext(this);
                }

                for (Map.Entry<String,BeanPostProcessor> entry2 : beanPostProcessors.entrySet()){
                    entry2.getValue().afterInitialIzation(bean);
                }




                if (aClass.isAssignableFrom(Init.class)){
                    Init init = (Init) bean;
                    init.init();
                }


            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            beanFactory.put((String) entry.getKey(), bean);

        }




        //3 init

        //4 销毁
    }

    private void prepareBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {
        beanFactoryPostProcessors.put("c",new ConfigBeanFactoryPostProcessor());
    }

    /**
     * 准备环境，对环境进行一些检查
     */
    private void prepareRefresh() {
        System.out.println("对环境进行一些检查,日志的配置,看看环境适不适合买蛋糕");
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.get(name);
    }


    @Override
    public InputStream readXML(String config) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(config);
    }
}
