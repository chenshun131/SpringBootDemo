package com.chenshun.consumer.util.command;

import com.chenshun.consumer.bean.User;
import com.chenshun.consumer.service.UserService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/5/1 14:41  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class UserBatchCommand extends HystrixCommand<List<User>> {

    private UserService userService;

    private List<Long> userIds;

    public UserBatchCommand(UserService userService, List<Long> userIds) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CommandGroupKey")).
                andCommandKey(HystrixCommandKey.Factory.asKey("CommandKey")).
                andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
        this.userService = userService;
        this.userIds = userIds;
    }

    @Override
    protected List<User> run() throws Exception {
        return userService.findAll(userIds);
    }

}
