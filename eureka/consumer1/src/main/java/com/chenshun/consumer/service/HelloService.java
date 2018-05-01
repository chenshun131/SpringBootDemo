package com.chenshun.consumer.service;

import com.chenshun.consumer.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * User: chenshun131 <p />
 * Time: 18/4/30 11:12  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 同步实现的方法
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {RuntimeException.class})
    public String helloService() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", String.class);
        return responseEntity.getBody();
    }

    /**
     * 异步实现的方法
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public Future<String> helloService2() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                ResponseEntity<String> responseEntity =
                        restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", String.class);
                return responseEntity.getBody();
            }
        };
    }

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "helloKey")
    public String hello() {
        long start = System.currentTimeMillis();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/hello", String.class);
        return responseEntity.getBody() + " >> 花费时间 : " + (System.currentTimeMillis() - start) + "ms";
    }

    public void hello1() {
        // 创建事件源 observable
        Observable<String> observable = Observable.unsafeCreate(subscriber -> {
            subscriber.onNext("Hello RxJava");
            subscriber.onNext("I'm 程序员");
            subscriber.onCompleted();
        });
        // 创建订阅者 subscriber
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber : " + s);
            }
        };
        // 订阅
        observable.subscribe(subscriber);
    }

    @HystrixCommand
    public Observable<String> getUserbyId(String id) {
        return Observable.unsafeCreate(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()) {
                    ResponseEntity<String> responseEntity =
                            restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun&id={1}", String.class, id);
                    String result = responseEntity.getBody();
                    subscriber.onNext(result);
                    subscriber.onCompleted();
                }
            } catch (RestClientException e) {
                e.printStackTrace();
                subscriber.onError(e);
            }
        });
    }

    public String helloFallback() {
        return "hello service is error";
    }

    @HystrixCommand(fallbackMethod = "dofaultUser")
    public User getUserbyId2(String id) {
        Map<String, String> uriVariables = new HashMap<>(1);
        uriVariables.put("name", "chenshun");
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user/{name}", User.class, uriVariables);
        return responseEntity.getBody();
    }

    @HystrixCommand(fallbackMethod = "dofaultUserSec")
    public User dofaultUser() {
        return new User("First Fallback");
    }

    public User dofaultUserSec() {
        return new User("Second Fallback");
    }

    @HystrixCommand(fallbackMethod = "fallback1", commandKey = "getUserById", groupKey = "UserGroup", threadPoolKey = "getUserByIdThread")
    public User getuserById(String id) {
        throw new RuntimeException("getUserById command failed");
    }

    public User fallback1(String id, Throwable e) {
        assert "getUserById command failed".equals(e.getMessage());
        return new User();
    }

    @CacheResult(cacheKeyMethod = "")
    @CacheRemove(commandKey = "", cacheKeyMethod = "")
    @HystrixCommand(commandKey = "getUserById", groupKey = "UserGroup", threadPoolKey = "getUserByIdThread")
    public User getuserById(Long id) {
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", User.class);
        return responseEntity.getBody();
    }

    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")
    @HystrixCommand
    public User getuserById2(Long id) {
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", User.class);
        return responseEntity.getBody();
    }

    public Long getUserByIdCacheKey(Long id) {
        return id;
    }

    @CacheResult
    @HystrixCommand
    public User getuserById3(@CacheKey("id") Long id) {
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name=chenshun", User.class);
        return responseEntity.getBody();
    }

    @CacheResult
    @HystrixCommand
    public User getuserById(@CacheKey("id") User user) {
        ResponseEntity<User> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name={1}", User.class, user.getName());
        return responseEntity.getBody();
    }

    @CacheRemove(commandKey = "getUserById")
    public User update(@CacheKey("id") User user) {
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name={1}", user, User.class);
        return responseEntity.getBody();
    }

    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")
    })
    public User find(Long id) {
        return restTemplate.getForObject("http://HELLO-SERVICE-GROUP/user?id={1}", User.class, id);
    }

    @HystrixCommand
    public List findAll(List<Long> ids) {
        return restTemplate.getForObject("http://HELLO-SERVICE-GROUP/user?ids={1}", List.class, StringUtils.join(ids, ","));
    }

}
