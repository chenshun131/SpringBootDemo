package com.chenshun.test.util.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/26 12:03  <p />
 * Version: V1.0  <p />
 * Description: 限流 <p />
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    /** 每秒生成多少个令牌 */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 需要是所有的优先级还要低
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 检测是否获取到令牌，没有获取到则抛出异常
        if (!RATE_LIMITER.tryAcquire()) {
            throw new RuntimeException();
        }
        return null;
    }

}
