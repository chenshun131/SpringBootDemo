package com.chenshun.consumer.util.command;

import com.chenshun.consumer.bean.User;
import com.chenshun.consumer.service.UserService;
import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: chenshun131 <p />
 * Time: 18/5/1 14:50  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class UserCollapseCommand extends HystrixCollapser<List<User>, User, Long> {

    private UserService userService;

    private Long userId;

    public UserCollapseCommand(HystrixCommand.Setter setter, UserService userService, Long userId) {
        super(HystrixCollapser.Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand")).
                andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public Long getRequestArgument() {
        return userId;
    }

    /**
     *
     * @param collapsedRequests
     * @return
     */
    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        List<Long> userIds = new ArrayList<>(collapsedRequests.size());
        userIds.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }

    @Override
    protected void mapResponseToRequests(List<User> batchResponse, Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        int count = 0;
        for (CollapsedRequest<User, Long> collapsedRequest : collapsedRequests) {
            User user = batchResponse.get(count++);
            collapsedRequest.setResponse(user);
        }
    }

}
