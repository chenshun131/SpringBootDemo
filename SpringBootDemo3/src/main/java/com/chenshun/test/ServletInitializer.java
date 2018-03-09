package com.chenshun.test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * User: mew <p />
 * Time: 18/3/9 9:36  <p />
 * Version: V1.0  <p />
 * Description:
 * 在 Servlet 容器中部署 WAR 的时候，不能依赖于 Application 的 main函数而是要以类似于 web.xml文件配置的方式来启动 Spring应用上下文 <br/>
 * 所以此时需要声明这样一个类或者将应用的主类改为继承 SpringBootServletInitializer 也可以 <br/>
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemo3Application.class);
    }

}
