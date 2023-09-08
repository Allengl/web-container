package com.gl.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCookieServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie1 = new Cookie("username","zhangsan");
        Cookie cookie2 = new Cookie("age","18");
        cookie1.setMaxAge(1000);
        cookie2.setMaxAge(1000);
        cookie1.setHttpOnly(true);
        String path = req.getContextPath();
        cookie1.setPath(path);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }


}
