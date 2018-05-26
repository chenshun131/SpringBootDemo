package com.chenshun.test.util.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * User: chenshun131 <p />
 * Time: 18/5/26 12:40  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();
        // 设置为 true，允许进行跨域
        config.setAllowCredentials(true);
        // 允许哪些 原始域 可以对当前网站进行跨域访问
        config.setAllowedOrigins(Arrays.asList("*"));
        // 允许的头信息
        config.setAllowedHeaders(Arrays.asList("*"));
        // 允许的方法
        config.setAllowedMethods(Arrays.asList("*"));
        // 设置缓存时间，在缓存时间内，对相同域名的请求不再做检查
        config.setMaxAge(300L);

        // 对所有路径进行配置
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
