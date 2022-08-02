package com.chen;

import com.chen.dao.DeptDao;
import com.chen.dao.EmployeeDao;
import com.chen.entity.Dept;
import com.chen.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 陈宇超
 * 15:04
 */
@Slf4j
public class TestDept {
    SqlSession sqlSession = null;
    DeptDao deptDao = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession(true);
        deptDao = sqlSession.getMapper(DeptDao.class);
    }

    @Test
    public void testFindAll(){
        List<Dept> deptList = deptDao.selectAll();
        for (Iterator<Dept> iterator = deptList.iterator(); iterator.hasNext(); ) {
            Dept next = iterator.next();
            log.info("dept is [{}]", deptList);
        }

    }

    @Test
    public void testSelectById(){
        Dept dept = deptDao.selectById(1);
        System.out.println(dept);
    }


}
