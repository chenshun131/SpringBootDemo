package com.chenshun.test.util.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * User: chenshun131 <p />
 * Time: 18/6/17 12:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class QueryParamPreFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1; // run before PreDecoration
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FilterConstants.FORWARD_TO_KEY) // a filter has already forwarded
                && !ctx.containsKey(FilterConstants.SERVICE_ID_KEY); // a filter has already determined serviceId
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getParameter("foo") != null) {
            // put the serviceId in `RequestContext`
            ctx.put(FilterConstants.SERVICE_ID_KEY, request.getParameter("foo"));
        }
        return null;
    }
}
