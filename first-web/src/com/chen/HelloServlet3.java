package com.chen;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 陈宇超
 * 15:09
 */
public class HelloServlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("每次处理业务的时候会执行");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name);
        System.out.println(age);
        System.out.println(req.getContextPath());
        System.out.println(req.getServletContext());
        System.out.println(req.getQueryString());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        /*resp.setStatus(302);
        resp.setHeader("Location", "https://wwww.baidu.com");*/

        resp.sendRedirect("https:www.sina.com.cn");
        System.out.println("业务执行结束");
    }
}
