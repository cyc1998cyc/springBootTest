package com.chen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 陈宇超
 * 14:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    /**
     * 部门编号（主键）
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    private List<Employee> employees;
}
