package com.gl.hotel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PostServlet extends MyGenericServlet{


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("PostServlet.service is called");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        res.getWriter().write("PostServlet.service is called");
    }
}
