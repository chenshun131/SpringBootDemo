package com.chenshun.test.service;

import org.springframework.stereotype.Service;

@Service
public interface HelloService {

    default String sayHello(String name) {
        return "Hello " + name;
    }

}
