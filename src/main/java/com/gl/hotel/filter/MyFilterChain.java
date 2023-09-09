package com.gl.hotel.filter;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;

public class MyFilterChain implements FilterChain {

    private ArrayList<Filter> filterList;

    private Servlet servlet;

    private int point;


    public MyFilterChain(ArrayList<Filter> filterList, Servlet servlet) {
        if(filterList == null) {
            filterList = new ArrayList<>();
        }
        filterList.add(new FilterProxy(servlet));
        this.filterList = filterList;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if(point < filterList.size()) {
            Filter filter = filterList.get(point);
            point ++;
            filter.doFilter(servletRequest, servletResponse, this);
        }
    }

    private static class FilterProxy extends HttpFilter {

        private Servlet servlet;

        public FilterProxy(Servlet servlet) {
            this.servlet = servlet;
        }

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            servlet.service(req, res);
        }
    }
}
