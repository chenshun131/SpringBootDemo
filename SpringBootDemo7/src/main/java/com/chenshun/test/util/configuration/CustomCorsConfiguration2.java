package com.chenshun.test.util.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * User: mew <p />
 * Time: 18/3/11 22:27  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Configuration
public class CustomCorsConfiguration2 implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
    }

}
