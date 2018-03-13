package com.chenshun.test.util.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: mew <p />
 * Time: 18/3/13 14:11  <p />
 * Version: V1.0  <p />
 * Description: springMVC配置 <p />
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册访问登录转向login.html页面
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}
