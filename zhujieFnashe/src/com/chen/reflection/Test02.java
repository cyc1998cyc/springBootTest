package com.chen.reflection;

import java.time.Year;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是：" + person.name);

        //通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //通过forNmae获得
        Class c2 = Class.forName("com.chen.reflection.Student");
        System.out.println(c2.hashCode());

        //通过类名.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //基本类型的包装类都有一个Type属性
        Class type = Integer.TYPE;
        System.out.println(type.hashCode());

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5.hashCode());

    }
}


class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";

    }
}


class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}