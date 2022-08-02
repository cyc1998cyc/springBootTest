package com.chen.dao;

import com.chen.entity.Employee;

import java.util.List;

/**
 * 陈宇超
 * 15:01
 */
public interface EmployeeDao {
    List<Employee> selectAll();

    List<Employee> selectInfo();
}
