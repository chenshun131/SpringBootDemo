package com.example.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 11:27  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 每次请求处理过程的地方
        System.out.println("time filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        // 过滤器销毁
        System.out.println("time filter destroy");
    }

}
