package com.gl.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePasswordServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String oldPassword= req.getParameter("oldPassword");
        String newPassword= req.getParameter("newPassword");
        if(PasswordClass.isUserRegistered(username,oldPassword)) {
            // 用户名和密码匹配，修改密码
            PasswordClass.registerUser(username, newPassword);
            resp.getWriter().write("change password success");
        } else {
            // 用户名和密码不匹配，修改失败
            resp.getWriter().write("username and password not match, change filed");

        }

    }
}
