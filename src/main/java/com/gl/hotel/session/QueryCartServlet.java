package com.gl.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QueryCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Object obj = session.getAttribute("cart");
        if(obj == null) {
            // 如果购物车为空, 则创建一个购物车
            resp.getWriter().write("no product in your cart");
        } else {
            // 如果购物车不为空, 则将商品添加到购物车中
            List<String> productList = (List<String>) obj;
            resp.getWriter().write("your cart has " + productList + " products");
        }

    }

}
