package com.chenshun.consumer.util.command;

import com.chenshun.consumer.bean.User;
import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * User: chenshun131 <p />
 * Time: 18/4/30 15:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class UserCommand extends HystrixCommand<User> {

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");

    private RestTemplate restTemplate;

    private Long id;

    public UserCommand(RestTemplate restTemplate, Long id) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandGroupKey")).
                andCommandKey(GETTER_KEY).
                andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user?nid={1}", User.class, id);
        return responseEntity.getBody();
    }

    @Override
    protected User getFallback() {
        Throwable throwable = getExecutionException();
        return new User();
    }

    @Override
    protected String getCacheKey() {
        // 根据 id 置入缓存
        return String.valueOf(id);
    }

    public static void flushCache(Long id) {
        // 刷新缓存，根据 id 进行清理
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }

}
