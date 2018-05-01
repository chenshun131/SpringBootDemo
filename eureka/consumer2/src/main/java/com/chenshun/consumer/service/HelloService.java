package com.chenshun.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/5/1 22:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
public class HelloService {

    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "dofaultUser",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "50")
            })
    public String getUser() {
        Map<String, String> uriVariables = new HashMap<>(1);
        uriVariables.put("name", "chenshun");
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user/{name}", String.class, uriVariables);
        return responseEntity.getBody();
    }

    public String dofaultUser() {
        return "error";
    }

}
