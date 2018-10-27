package com.chenshun.test.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UserListener implements ServletContextListener {

    /**
     * 监听ServletContext销毁
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("UserListener...contextDestroyed...");
    }

    /**
     * 监听ServletContext启动初始化
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext servletContext = arg0.getServletContext();
        System.out.println("UserListener...contextInitialized...");
    }
}
