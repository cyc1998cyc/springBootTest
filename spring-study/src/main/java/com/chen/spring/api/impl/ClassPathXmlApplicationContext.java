package com.chen.spring.api.impl;

import com.chen.spring.api.ApplicationContext;
import com.chen.spring.api.ApplicationContextAware;
import com.chen.spring.api.Init;
import com.chen.spring.api.Resource;

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

    private ConcurrentHashMap<String, Object> beanFactory;

    private Properties beanDefinitions = new Properties();

    public ClassPathXmlApplicationContext(String config) {
        InputStream inputStream = readXML(config);
        Properties properties = new Properties();
        try {
            //通过配置文件加载bean的定义
            properties.load(inputStream);
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

        //3.准备工作
        prepareBeanFactory(beanFactory);

        try {
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

        //2.调用方法
    }

    private void finishBeanFactoryInitialization(ConcurrentHashMap<String, Object> beanFactory) {
        for(Map.Entry<Object,Object> entry : beanDefinitions.entrySet()){
            String className = (String) entry.getValue();
            Object instance = null;
            try {
                //1 创建
                Class<?> aClass = Class.forName(className);
                Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                instance = declaredConstructor.newInstance();


                //2 依赖注入 属性填充


                //3 init
                if (aClass.isAssignableFrom(ApplicationContextAware.class)){
                    ApplicationContextAware applicationContextAware = (ApplicationContextAware) instance;
                    applicationContextAware.setApplicationContext(this);
                }


                if (aClass.isAssignableFrom(Init.class)){
                    Init init = (Init) instance;
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
            beanFactory.put((String) entry.getKey(), instance);

        }




        //3 init

        //4 销毁
    }

    private void prepareBeanFactory(ConcurrentHashMap<String, Object> beanFactory) {
        System.out.println("做了一些准备工作");
    }

    private void prepareRefresh() {
        System.out.println("对环境进行一些检查,日志的配置,看看环境适不适合买蛋糕");
    }

    @Override
    public Object getBean(String name) {
        return null;
    }


    @Override
    public InputStream readXML(String config) {
        return null;
    }
}
