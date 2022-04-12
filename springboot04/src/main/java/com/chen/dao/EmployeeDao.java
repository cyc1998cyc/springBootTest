package com.chen.dao;

import com.chen.pojo.Department;
import com.chen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartMentDao departMentDao;

    //模拟数据库中的操作
    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表


    }
}
