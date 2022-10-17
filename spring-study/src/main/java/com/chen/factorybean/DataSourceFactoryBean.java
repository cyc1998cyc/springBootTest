package com.chen.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class DataSourceFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        //实例化一个bean 交给容器管理,这个创建的过程是复杂的，甚至我们连类都不知道

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
