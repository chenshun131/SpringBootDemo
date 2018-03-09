package com.chenshun.core.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenshun.api.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * User: mew <p />
 * Time: 18/3/9 17:07  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHellow() {
        return "这是一个 java 测试项目";
    }

}
