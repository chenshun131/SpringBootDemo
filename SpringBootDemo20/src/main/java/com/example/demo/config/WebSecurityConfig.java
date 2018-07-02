package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 13:41  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic() // formLogin() 指定使用表单登录

                .and()
                // 表示这个不需要验证 登录页面，登录失败页面
                .authorizeRequests().anyRequest().authenticated()

                .and()
                .csrf().disable();
    }
}