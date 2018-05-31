package com.chenshun.springbootdemo19.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: mew <p />
 * Time: 18/5/31 11:53  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mystatic/**")
                .addResourceLocations("classpath:/mystatic/");
    }

}
