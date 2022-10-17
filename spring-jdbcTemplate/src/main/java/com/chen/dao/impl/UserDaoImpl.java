package com.chen.dao.impl;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User selectById(int id) {
        List<User> query = jdbcTemplate.query("select * from user where id = ?", new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int id = resultSet.getInt("id");


                return new User(id, username, password);
            }
        });
        return query.size() == 0 ? null : query.get(0);
    }
}
