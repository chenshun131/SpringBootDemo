package com.chenshun.test.util.configuration;

import com.chenshun.test.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User: mew <p />
 * Time: 18/3/13 13:49  <p />
 * Version: V1.0  <p />
 * Description: Spring Security配置，扩展 SpringSecurity 配置需要继承 WebSecurityConfigurerAdapter <p />
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册UserDetailsService的bean
     *
     * @return
     */
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 添加自定义的 userDetailsService 认证
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()//所有的请求需要认证即登陆后才能访问
                .and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() // 登录页面可任意访问
                .and()
                .logout().permitAll(); // 注销请求可任意访问
    }

}
