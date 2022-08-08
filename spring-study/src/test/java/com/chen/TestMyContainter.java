package com.chen;


import org.junit.Test;

public class TestMyContainter {
    @Test
    public void test1(){
        System.out.println("1231231231");
        ChenContainer.MAP.put("userDao",new UserDao());
    }
}
