package com.chenshun.test.util.listerner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * User: mew <p />
 * Time: 18/3/11 22:13  <p />
 * Version: V1.0  <p />
 * Description: 自定义listener <p />
 */
@WebListener
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
