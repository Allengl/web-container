package com.gl.hotel;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.*;

public class WebContainer {

    Map<String, String> urlPatternToServletClass = new HashMap<>();
    Map<String, Servlet> urlPatternToServletObject = new HashMap<>();


    /**
     * 1. 启动 web 容器
     */
    public void start(List<ServletConfiguration> servletConfigurations) throws InstantiationException, IllegalAccessException, ClassNotFoundException, ServletException {
        List<ServletConfiguration> servletNeedToLoadOnStartup = new ArrayList<>();

        for (ServletConfiguration servletConfiguration : servletConfigurations) {
            String urlPattern = servletConfiguration.getUrlPattern();
            String servletClass = servletConfiguration.getServletClass();
            urlPatternToServletClass.put(urlPattern, servletClass);
            Integer loadOnStartup = servletConfiguration.getLoadOnStartup();
            if (loadOnStartup != null && loadOnStartup > 0) {
                // 是不是在这里创建 servlet 对象
                // 不是，因为 loadOnStartup 有优先级的概念，数值越小，优先级越高
                servletNeedToLoadOnStartup.add(servletConfiguration);
            }
        }
        // 安装 loadOnStartup 的优先级排序(升序)
        servletNeedToLoadOnStartup.sort(Comparator.comparing(v -> v.getLoadOnStartup()));

        // 1.1. 创建 Servlet 对象
        for (ServletConfiguration servletConfiguration : servletNeedToLoadOnStartup) {
            String servletClass = servletConfiguration.getServletClass();
            String urlPattern = servletConfiguration.getUrlPattern();
            createServletObj(servletClass, urlPattern);
        }

    }

    private Servlet createServletObj(String servletClass, String urlPattern) throws ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        Class clazz = Class.forName(servletClass);
        Servlet servlet = (Servlet) clazz.newInstance();
        servlet.init(null);
        urlPatternToServletObject.put(urlPattern, servlet);
        return servlet;
    }
    /**
     * 2. 执行请求
     */
    public void doService(String urlPattern, ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 情况一: 如果请求路径和 Servlet 对象之间的映射关系已经存在，直接获取 Servlet 对象，调用 Servlet.service 方法
        if(urlPatternToServletObject.containsKey(urlPattern)){
            Servlet servlet = urlPatternToServletObject.get(urlPattern);
            servlet.service(servletRequest, servletResponse);
        }
        // 情况二: 如果请求路径和 Servlet 对象之间的映射关系不存在，但是请求路径和 Servlet 类之间的映射关系存在，创建 Servlet 对象，调用 Servlet.init 方法，然后调用 Servlet.service 方法
        if(urlPatternToServletClass.containsKey(urlPattern)){
            String servletClass = urlPatternToServletClass.get(urlPattern);
            Servlet servlet = createServletObj(servletClass, urlPattern);
            servlet.service(servletRequest, servletResponse);
            return;
        }
        // 情况三: 如果用户输入的请求路径不存在
        else {
            System.out.println("请求路径有误");
        }
    }


    /**
     * 3. 关闭 web 容器
     */
    public void close() {
        // 1. 销毁所有的 Servlet 对象
        for (Servlet servlet : urlPatternToServletObject.values()) {
            servlet.destroy();
        }
    }

}
