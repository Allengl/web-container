package com.gl.hotel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostServlet extends HttpServlet {

//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        System.out.println("PostServlet.service is called");
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("password"));
//        res.getWriter().write("PostServlet.service is called");
//    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PostServlet.service is called");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        resp.getWriter().write("PostServlet.service is called");
    }


}
