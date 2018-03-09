package com.chenshun.test;

import com.chenshun.test.util.filter.CustomFilter;
import com.chenshun.test.util.servlet.CustomServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * User: mew <p />
 * Time: 18/3/9 11:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class test {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CustomServlet(), "/customServlet2");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
    }

}
