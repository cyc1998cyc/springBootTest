package com.chen;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.UUID;

/**
 * 陈宇超
 * 11:33
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("jsessionid", UUID.randomUUID().toString());
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

        HttpSession session = req.getSession();
        session.setAttribute("user", "zs");

    }
}
