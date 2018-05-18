package com.chenshun.test.util.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * User: mew <p />
 * Time: 18/5/17 10:25  <p />
 * Version: V1.0  <p />
 * Description: Zuul 过滤器，在请求被路由检查之前检查 HttpServletRequest 中是否有 accessToken 参数 <br/>
 * 若有就进行路由，若没有就拒绝访问，返回 401 Unauthorized 错误<p/>
 */
@Component
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤的类型，它决定过滤在请求的哪个生命周期中执行，这里是 pre 代表在请求被路由之前执行
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，当请求在一个阶段中存在多个过滤时，需要根据该方法返回的值来依次执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行，此处直接返回 true 因此该过滤器对所有请求都会生效。实际运用中可以利用该函数来指定过滤器的有效范围
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，此处使用 ctx.setSendZuulResponse(false) 表示不进行路由然后使用 ctx.setResponseStatusCode(401) 指定错误码， <br/>
     * 使用 ctx.setResponseBody("have some erroe") 指定返回 body 内容
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
//        throw new ZuulRuntimeException(new Exception("have some error"));

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("have some error");
            return null;
        }
        logger.info("access token ok");
        return null;
    }

}
