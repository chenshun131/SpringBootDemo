package com.chenshun.test;

import com.chenshun.test.filter.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemo30Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo30Application.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtAuthenticationFilter());
        return registrationBean;
    }

}
