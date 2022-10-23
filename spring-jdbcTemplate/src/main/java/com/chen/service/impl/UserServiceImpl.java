package com.chen.service.impl;

import com.chen.dao.UserDao;
import com.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User selectById(int id) {
        return userDao.selectById(id);
    }
}
