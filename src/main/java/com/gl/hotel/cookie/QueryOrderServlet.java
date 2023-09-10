package com.gl.hotel.cookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class QueryOrderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(10);

        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);

        // 检验用户是否登录
        String username = getCookieValue(req, "username");
        System.out.println(username + "is querying order");
        resp.getWriter().write("查询订单");
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
