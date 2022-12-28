package com.chen.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 陈宇超
 * 14:52
 */
public class User  implements BeanFactoryAware {


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }
}

class User1 implements BeanPostProcessor{

}

class User2 implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

class User3 implements DisposableBean {

    @Override
    public void destroy() throws Exception {

    }
}

class User4{

}



