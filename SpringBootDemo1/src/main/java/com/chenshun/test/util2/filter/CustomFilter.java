package com.chenshun.test.util2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * User: mew <p />
 * Time: 18/3/9 13:38  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@WebFilter(filterName = "customFilter", urlPatterns = "/*", servletNames = {"customServlet3"})
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter3");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("do filter3");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy filter3");
    }

}
