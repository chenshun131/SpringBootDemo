package com.chenshun.consumer.controller;

import com.chenshun.consumer.bean.User;
import com.chenshun.consumer.service.HelloService;
import com.chenshun.consumer.util.command.UserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * User: chenshun131 <p />
 * Time: 18/4/30 11:16  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin(allowCredentials = "true") // 表示允许 Cookie 跨域
    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        // 同步执行
        String result = new UserCommand(restTemplate, 1L).execute().toString();
        // 异步执行，返回的 Future 对象通过 Get 来获取结果
        Future<User> future = new UserCommand(restTemplate, 1L).queue();
        return result;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        // 返回 Hot Observable，在 observe() 方法调用的时候立即执行，当 Observable 每次订阅的时候会重放它的行为
        Observable<User> ho = new UserCommand(restTemplate, 1L).observe();
        // 返回 Cloud Observable，在 toObservable() 方法调用后不会立即执行，只有当所有订阅者都订阅它之后才会执行
        Observable<User> co = new UserCommand(restTemplate, 1L).toObservable();
        return "";
    }

}
