package com.gl.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuerySessionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.getWriter().write("您还没有访问过本站");
        } else {
            Object obj = session.getAttribute("count");

            if (obj == null) {
                resp.getWriter().write("you have not visited this site");
            } else {
                int count = (int) obj;
                resp.getWriter().write("you already visited this site" + " " + count + " " + "times");
            }
        }
    }
}
