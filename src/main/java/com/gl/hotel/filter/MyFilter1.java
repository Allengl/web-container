package com.gl.hotel.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter1 extends HttpFilter {
    public MyFilter1() {
        System.out.println("MyFilter1 constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("MyFilter1 init");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter1 destroy");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter1 before");
        chain.doFilter(req, res);
        System.out.println("MyFilter1 after");
    }
}
