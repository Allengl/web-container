package com.gl.hotel;

import javax.servlet.*;
import java.io.IOException;

public class DemoServlet extends MyGenericServlet{


    @Override
    public void init( ) throws ServletException {

    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("DemoServlet service");
    }

}
