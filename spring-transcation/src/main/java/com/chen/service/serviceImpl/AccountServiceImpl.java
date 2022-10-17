package com.chen.service.serviceImpl;

import com.chen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSourceTransactionManager transactionManager;


    @Override
    public void transfer(String from, String to, Integer money) {


        // 转账其实是两个语句
        String moneyFrom = "update account set money = 100 where username = chenyuchao ";
        String moneyTo = "update account set money = 100 where username = zhangsan ";
        // 从转账的人处扣钱

        jdbcTemplate.update(moneyFrom);
        jdbcTemplate.update(moneyTo);


    }
}
