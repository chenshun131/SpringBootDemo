package com.chenshun.test.util2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * User: mew <p />
 * Time: 18/3/9 13:38  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@WebListener
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized3");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed3");
    }

}
