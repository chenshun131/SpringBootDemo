package com.chenshun.test.util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * User: mew <p />
 * Time: 18/3/9 11:35  <p />
 * Version: V1.0  <p />
 * Description: 自定义listener <p />
 */
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }

}
