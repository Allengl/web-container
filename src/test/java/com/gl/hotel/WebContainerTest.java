package com.gl.hotel;

import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WebContainerTest {
    private  List<ServletConfiguration> buildConfiguration() {
        // 不配置 loadOnStartup
        ServletConfiguration bookRoomServletConfiguration = new ServletConfiguration(
                "/bookRoom",
                "com.gl.hotel.BookRoomServlet",
                null
        );

        // 配置 loadOnStartup 为 1
        ServletConfiguration checkInServletConfiguration = new ServletConfiguration(
                "/checkIn",
                "com.gl.hotel.CheckInServlet",
                1
        );

        // 配置 loadOnStartup 为 0
        ServletConfiguration checkOutServletConfiguration = new ServletConfiguration(
                "/checkOut",
                "com.gl.hotel.CheckOutServlet",
                1
        );

        // 配置 loadOnStartup 为 -1
        ServletConfiguration queryRoomServletConfiguration = new ServletConfiguration(
                "/queryRoom",
                "com.gl.hotel.QueryRoomServlet",
                -1
        );

        // 不配置 loadOnStartup
        // endServlet
        ServletConfiguration endServletConfiguration = new ServletConfiguration(
                "/end",
                "com.gl.hotel.EndServlet",
                null
        );
        List<ServletConfiguration> servletConfigurationList = new ArrayList<>();
        servletConfigurationList.add(bookRoomServletConfiguration);
        servletConfigurationList.add(checkInServletConfiguration);
        servletConfigurationList.add(checkOutServletConfiguration);
        servletConfigurationList.add(queryRoomServletConfiguration);
        servletConfigurationList.add(endServletConfiguration);
        return servletConfigurationList;
    }

    @Test
    public void testWebContainer() throws ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        // 1.获取配置信息
        List<ServletConfiguration> servletConfigurationList = buildConfiguration();
        // 2.创建 Web 容器
        WebContainer webContainer = new WebContainer();
        // 3.启动 Web 容器
        webContainer.start(servletConfigurationList);
        // 4.用户发起请求
        // 4.1 查询房间
        webContainer.doService("/queryRoom", null, null);
        // 4.2 预定房间
        webContainer.doService("/bookRoom", null, null);
        // 4.3 入住
        webContainer.doService("/checkIn", null, null);
        // 4.4 退房
        webContainer.doService("/checkOut", null, null);
        // 5 关闭容器
        webContainer.close();

        // 预期结果
        // CheckOutServlet.init is called
        // CheckInServlet.init is called
        // QueryRoomServlet.init is called
        // QueryRoomServlet.service is called
        // BookRoomServlet.init is called
        // 连接数据库
        // BookRoomServlet.service is called
        // 写数据库
        // CheckInServlet.service is called
        // CheckOutServlet.service is called
        // 调用所有 Servlet 的 destroy 方法
        // 关闭数据库连接
    }
}