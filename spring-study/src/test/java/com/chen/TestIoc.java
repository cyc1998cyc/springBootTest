package com.chen;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 陈宇超
 * 10:26
 */

public class TestIoc {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestIoc.class);
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = context.getBean(UserDao.class);
        //UserDao userDao = (UserDao)context.getBean("userDao2");
        LOGGER.info("userDao is [{}]", userDao);
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        userService.hello();

    }

    @Test
    public void test03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        User user = context.getBean(User.class);
        LOGGER.info("user is [{}]",user.toString());
        context.close();

    }

    @Test
    public void test04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = context.getBean(UserDao.class);
        context.close();

    }

    @Test
    public void test05(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aware.xml");
        C c = context.getBean(C.class);
        c.printName();
    }
}
