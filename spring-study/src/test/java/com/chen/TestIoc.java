package com.chen;

import com.chen.dao.OrderDao;
import com.chen.listener.EmailListener;
import com.chen.listener.OrderEvent;
import com.chen.spring.MyConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    @Test
    public void testScan(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scan.xml");
        OrderDao orderDao = (OrderDao)context.getBean(OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testScan2(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.chen");
        OrderDao orderDao = (OrderDao)annotationConfigApplicationContext.getBean(OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testValue(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class );
        MyConfig myConfig = ctx.getBean(MyConfig.class);
        System.out.println(myConfig);
    }

    @Test
    public void testListener(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EmailListener.class);
        ctx.publishEvent(new OrderEvent("123","chenyuchao","123"));
    }
}
