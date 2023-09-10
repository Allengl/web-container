package com.gl.hotel.filter;

import com.gl.hotel.cookie.PasswordClass;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = "/cookie/*")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 如果是登录请求，放行
        String uri = req.getRequestURI();
        if (uri.endsWith("login.html") || uri.endsWith("login")) {
            System.out.println("登录请求，放行");
            chain.doFilter(req, resp);
            return;
        }
        // 检验用户是否登录
        String username = getCookieValue(req, "username");
        String password = getCookieValue(req, "password");
        String path = req.getContextPath();
        if (username == null || password == null) {
            // 用户未登录，调整到登录页面
            resp.sendRedirect(path + "/login.html");
        } else {
            // 校验用户名和密码是否正确
            if (PasswordClass.verify(username, password)) {
                // 用户名和密码不匹配，调整到登录页面
                // 验证通过，放行请求
                System.out.println("验证通过");
                chain.doFilter(req, resp);
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
