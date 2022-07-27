package com.chen;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.UUID;

/**
 * 陈宇超
 * 11:33
 */
public class SessionServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //访问时会创建session
        HttpSession session = req.getSession();
        session.setAttribute("username", "chenyuchao");

    }
}
