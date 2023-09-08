package com.gl.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryEmptyRoomServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 检验用户是否登录
        String username = getCookieValue(req, "username");
        String password = getCookieValue(req, "password");
        String path = req.getContextPath();
        if (username == null || password == null) {
            // 用户未登录，调整到登录页面
            resp.sendRedirect(path + "/login.html");
        } else {
            // 校验用户名和密码是否正确
            if (PasswordClass.isUserRegistered(username, password)) {
                // 用户名和密码不匹配，调整到登录页面
                // 查询空房间
                System.out.println("QueryEmptyRoomServlet.doGet is called");
                resp.getWriter().write(username + "is querying empty room");
            } else {
                //清除 cookie
                Cookie cookie1 = new Cookie("username", "11");
                cookie1.setMaxAge(0);
                cookie1.setPath(path);
                resp.addCookie(cookie1);
                Cookie cookie2 = new Cookie("password", "11");
                cookie2.setMaxAge(0);
                cookie2.setPath(path);
                resp.addCookie(cookie2);
                resp.sendRedirect("/hotel/login.html");

            }


        }

    }

    private String getCookieValue(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
