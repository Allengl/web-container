package com.gl.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateSessionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Object obj = session.getAttribute("count");
        if(obj == null) {
            // 第一次访问
            session.setAttribute("count", 1);
        } else {
            // 不是第一次访问, 将count + 1
            session.setAttribute("count", (int)obj + 1);
        }
    }

}
