package com.chen.dao;

import com.chen.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 陈宇超
 * 14:32
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> select();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 根据id和username查询
     */
    User selectByIdAndUsername(@Param("id") int id, @Param("username") String username);

    User selectByUser(User user);

    User selectByMap(Map<String, Object> paramMap);

    List<User> selectByUsername(@Param("username1") String username);

    int insert(User user);

    int delete(User user);
}
