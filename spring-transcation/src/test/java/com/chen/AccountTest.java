package com.chen;

import com.chen.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public  void testTransfer(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.transfer("chenyuchao","zhangsan",100);
    }
}
