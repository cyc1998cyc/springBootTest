package com.chen;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 陈宇超
 * 15:09
 */
public class HelloServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("开启tomcat的时候只会执行一次");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*System.out.println("每次处理业务的时候会执行");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("do you like what you see ?");
        writer.close();
        System.out.println("业务执行结束");*/

        System.out.println("我处理了一部分工作，接下来由其他功能处理");
    //    进行转发
        servletRequest.getRequestDispatcher("/hello3").forward(servletRequest, servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("tonmcat关闭的时候会执行");
    }
}
