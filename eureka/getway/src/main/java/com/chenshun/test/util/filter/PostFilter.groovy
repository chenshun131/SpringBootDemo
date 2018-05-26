package com.chenshun.test.util.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.servlet.http.HttpServletResponse

/**
 * User: chenshun131 <p />
 * Time: 18/5/26 11:41  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
class PostFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(PostFilter.class);

    @Override
    String filterType() {
        return "post"
    }

    @Override
    int filterOrder() {
        return 2000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() throws ZuulException {
        log.info("this is a post filter : Receive response")
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse()
        response.flushBuffer()
    }

}
