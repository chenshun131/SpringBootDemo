package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: chenshun131 <p />
 * Time: 18/6/24 11:51  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 请求之前调用，返回 true 执行之后的操作，返回 false 将直接被拦截不进行之后的处理操作
        System.out.println("preHandle");

        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理完成之后被调用，不抛出异常才能被访问
        System.out.println("postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 请求处理完成之后被调用，不管出不出现异常都会被调用
        System.out.println("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("time interceptor 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("ex is " + ex);
    }

}
