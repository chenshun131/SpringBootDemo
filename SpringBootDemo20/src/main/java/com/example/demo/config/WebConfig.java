package com.example.demo.config;

import com.example.demo.filter.TimeFilter;
import com.example.demo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 11:59  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

//    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 没有 @Component 相关的注解
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        // 指定作用路径的 URL
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }

}
