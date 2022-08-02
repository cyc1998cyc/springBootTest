package com.chen.dao;

import com.chen.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 陈宇超
 * 15:01
 */
public interface EmployeeDao {
    List<Employee> selectAll();

    List<Employee> selectInfo();

    List<Employee> select2();

    List<Employee> selectByDid(@Param("dId") Integer dId);
}
