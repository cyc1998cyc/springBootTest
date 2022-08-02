package com.chen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 陈宇超
 * 14:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee  implements Serializable {
    /**
     * 员工id（主键）
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工部门编号
     */
    private Integer dId;

    /**
     * 部门名称
     */
    private String dName;

    /**
     * 部门
     */
    private Dept dept;
}
