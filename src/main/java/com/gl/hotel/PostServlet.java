package com.gl.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        // d、第一步：读取请求内容
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(
                req.getInputStream(), "UTF-8"
        ));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        // 第二步：把 json 数据转成对象
        ObjectMapper objectMapper = new ObjectMapper();
        UserPassword userPassword =  objectMapper.readValue(responseStrBuilder.toString(), UserPassword.class);
        // 上面两个步骤之后是 SpringMVC 框架完成的，我们接受到前端请求直接就能拿到对象

        System.out.println(userPassword);

        // 第三步：把对象转成 json
        String json = objectMapper.writeValueAsString(userPassword);
        System.out.println(json);
        resp.getWriter().write(responseStrBuilder.toString());
   }


}
