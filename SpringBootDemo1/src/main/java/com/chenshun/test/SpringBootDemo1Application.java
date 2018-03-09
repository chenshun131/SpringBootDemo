package com.chenshun.test;

import com.chenshun.test.util.filter.CustomFilter;
import com.chenshun.test.util.listener.CustomListener;
import com.chenshun.test.util.servlet.CustomServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@ServletComponentScan
@SpringBootApplication
public class SpringBootDemo1Application implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("customServlet1", new CustomServlet()).addMapping("/roncoo");
        servletContext.addFilter("customFilter1",
                new CustomFilter()).addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
        servletContext.addListener(new CustomListener());
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CustomServlet(), "/customServlet");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
    }

    @Bean
    public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new CustomListener());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo1Application.class, args);
    }

}
