package com.chenshun.test.util.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: mew <p />
 * Time: 18/3/9 11:35  <p />
 * Version: V1.0  <p />
 * Description: 自定义filter <p />
 */
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("do filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter");
    }

}
