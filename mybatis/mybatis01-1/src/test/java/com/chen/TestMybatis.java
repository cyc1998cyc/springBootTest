package com.chen;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 陈宇超
 * 18:15
 */
@Slf4j
public class TestMybatis {
    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //System.out.println(sqlSessionFactory);
        /*User user = new User();
        user.setId(1812244);
        user.setUsername("chenyuchao");
        user.setPassword("1812244d");*/

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> objectList = sqlSession.selectList("user.select");
        log.debug("result is [{}]",objectList);
    }
}
