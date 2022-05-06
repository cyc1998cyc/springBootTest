package com.chen.reflection;


//什么叫反射
public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.chen.reflection.User");
        Class c2 = Class.forName("com.chen.reflection.User");
        Class c3 = Class.forName("com.chen.reflection.User");

        //输出结果为相同，证明一个类只有一个Class对象
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        User user = new User();
        int c4 = user.getClass().hashCode();
        System.out.println(c4);

    }
}


/**
 * 随意定义一个实体类
 */
class User{
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
