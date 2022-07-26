package com.chen;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 陈宇超
 * 15:09
 */
public class HelloServlet2 extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次处理业务的时候会执行");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("do you like what you see ?");
        writer.close();
        System.out.println("业务执行结束");
    }
}
