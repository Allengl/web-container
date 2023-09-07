package com.gl.hotel;

import javax.servlet.*;
import java.io.IOException;

public class QueryRoomServlet implements Servlet {

    public QueryRoomServlet() {
        System.out.println("QueryRoomServlet is created");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("QueryRoomServlet init is created");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("QueryRoomServlet.service is called");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("QueryRoomServlet is destroyed");
    }
}