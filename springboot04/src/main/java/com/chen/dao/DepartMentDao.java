package com.chen.dao;

import com.chen.pojo.department;

import java.util.HashMap;
import java.util.Map;

/**
 * 陈宇超
 * 18:23
 */

//部门dao
public class DepartMentDao {

    //模拟数据库中的初始化数据
    private static Map<Integer, department> departments = null;

    static {
        departments = new HashMap<Integer, department>();//创建一个部门表

        departments.put(101, new department(101,""));


    }
}
