package com.chenshun.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: mew <p />
 * Time: 18/4/25 10:51  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/print", String.class).getBody();
    }

}
