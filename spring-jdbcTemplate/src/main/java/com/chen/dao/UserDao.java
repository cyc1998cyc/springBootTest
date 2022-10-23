package com.chen.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 根据id查询用户
     * @return
     */
    User selectById(int id);
}
