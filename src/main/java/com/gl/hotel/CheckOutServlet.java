package com.gl.hotel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CheckOutServlet extends MyGenericServlet{

        @Override
        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("CheckOutServlet.service is called");
        }

        @Override
        public void init() throws ServletException {
            System.out.println("CheckOutServlet.init is called");
        }
}
