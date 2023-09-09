package com.gl.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (PasswordClass.verify(username, password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setPath(req.getContextPath());
            cookie.setHttpOnly(true);
            cookie.setMaxAge(24 * 30 * 60);
            resp.addCookie(cookie);

            Cookie cookie2 = new Cookie("password", password);
            cookie2.setPath(req.getContextPath());
            cookie2.setHttpOnly(true);
            cookie2.setMaxAge(24 * 30 * 60);
            resp.addCookie(cookie2);
            System.out.println("登录成功");
            resp.getWriter().write("login success");
        } else {
            resp.getWriter().write("login failed");
        }

    }
}
