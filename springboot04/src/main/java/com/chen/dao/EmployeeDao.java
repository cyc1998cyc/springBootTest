package com.chen.dao;

import com.chen.pojo.Department;
import com.chen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private static DepartMentDao departMentDao = new DepartMentDao();

    //模拟数据库中的操作
    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001,new Employee(101,"chenyuchao1","email",1,departMentDao.getDepartmentById(101),new Date()));
        employees.put(1002,new Employee(101,"chenyuchao2","email",1,departMentDao.getDepartmentById(101),new Date()));
        employees.put(1003,new Employee(101,"chenyuchao3","email",1,departMentDao.getDepartmentById(101),new Date()));
        employees.put(1004,new Employee(101,"chenyuchao4","email",1,departMentDao.getDepartmentById(101),new Date()));
        employees.put(1005,new Employee(101,"chenyuchao5","email",1,departMentDao.getDepartmentById(101),new Date()));


    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartMent(departMentDao.getDepartmentById(employee.getDepartMent().getId()));

        employees.put(employee.getId(),employee);

    }


    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
