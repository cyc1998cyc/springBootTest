package com.chen.dao;

import com.chen.entity.Dept;

import java.util.List;

/**
 * 陈宇超
 * 15:01
 */
public interface DeptDao {
    List<Dept> selectAll();

    Dept selectById(Integer id);
}
