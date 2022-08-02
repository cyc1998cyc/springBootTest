package com.chen;

import com.chen.dao.DeptDao;
import com.chen.dao.EmployeeDao;
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
 * 15:52
 */
@Slf4j
public class TestEmployee {
    SqlSession sqlSession = null;
    EmployeeDao employeeDao = null;

    @Before
    public void before() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession(true);
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
    }

    @Test
    public void testSelectAll(){
        List<Employee> employeeList = employeeDao.selectAll();
        for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            log.info("employee is [{}]",next);
            log.info("dept is [{}]",next.getDept());
        }
    }

    @Test
    public void testSelectInfo(){
        List<Employee> employees = employeeDao.selectInfo();
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            log.info("employee is [{}]",next);
            log.info("dept is [{}]",next.getDept());
        }
    }
}
