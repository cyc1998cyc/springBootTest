package com.chen;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 陈宇超
 * 18:15
 */
@Slf4j
public class TestMybatis {
    SqlSession sqlSession = null;
    UserDao userDao = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> objectList = sqlSession.selectList("user.select");
        log.debug("result is [{}]",objectList);
    }

    @Test
    public void test02(){

        List<User> userList = userDao.select();
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
            User next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void testSelectOne(){
        User user = userDao.selectById(1);
        log.debug("user = [{}]",user);
    }

    @Test
    public void testSelectByIdAndUsername(){
        User itnanls = userDao.selectByIdAndUsername(1, "itnanls");
        log.debug("user id [{}]",itnanls);
    }

    @Test
    public void testSelectByUser(){
        User user = new User(2,"itlils","abcdef");
        user = userDao.selectByUser(user);
        log.info("user = [{}]",user);

    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("username", "itnanls");
        paramMap.put("password", "123456");
        User user = userDao.selectByMap(paramMap);
        log.info("user = [{}]",user);
    }

    @Test
    public void testSelectByUsername(){
        List<User> userList = userDao.selectByUsername("c");
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
            User next = iterator.next();
            log.info("user = [{}]",next);
        }
    }

    @Test
    public void TestInsert(){
        try {
            User user = new User(8, "chen12", "1812244d1");
            int affectRows = userDao.insert(user);

            List<User> userList = userDao.select();
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User next = iterator.next();
                log.info("user = [{}]",next);
            }
            log.debug("受影响的行数=[{}]", affectRows);
            int i = 1/0;
            sqlSession.commit();
        } catch (Exception e) {
            log.error("异常信息", e);
        }
    }

    @Test
    public void testDelete(){
        try {
            User user = new User(7, "chen12", "1812244d1");
            int affectRows = userDao.delete(user);

            List<User> userList = userDao.select();
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User next = iterator.next();
                log.info("user = [{}]",next);
            }
            log.debug("受影响的行数={}", affectRows);
            //int i = 1/0;
            sqlSession.commit();
        } catch (Exception e) {
            log.error("异常信息：[{}]", e);
        }
    }

    @Test
    public void testFindByAllConditons(){
        User user = new User();
        user.setId(null);
        user.setPassword("2");
        user.setUsername("chen");
        List<User> userList = userDao.selectByAllConditions(user);
        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
            User next = iterator.next();
            log.info("user = [{}]",next);
        }
    }


}
