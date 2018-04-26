package com.chenshun.provider.controller;

import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/4/24 17:27  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
public class HelloController {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
//        discoveryClient.getAllKnownRegions().forEach(logger::info);
        return "Hello World";
    }

}
