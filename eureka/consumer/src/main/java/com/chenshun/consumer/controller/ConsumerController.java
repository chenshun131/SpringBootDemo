package com.chenshun.consumer.controller;

import com.chenshun.consumer.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user/chenshun", String.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/user2", method = RequestMethod.GET)
    public String user2() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user2?name={1}", String.class, "chenshun");
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/user3", method = RequestMethod.GET)
    public String user3() {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("name", "chenshun");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE-GROUP/hello/user/{name}", String.class, uriVariables);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/user4", method = RequestMethod.GET)
    public String user4() {
        Map<String, String> uriVariables = new HashMap<>(1);
        uriVariables.put("name", "chenshun");
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE-GROUP/hello/user/{name}").build().
                expand(uriVariables).encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping(value = "/user5", method = RequestMethod.GET)
    public String user5() {
        return restTemplate.getForObject("http://HELLO-SERVICE-GROUP/hello/user2?name={1}", String.class, "chenshun");
    }

    @RequestMapping(value = "/user6", method = RequestMethod.GET)
    public void user6() {
        Map<String, String> uriVariables = new HashMap<>(1);
        uriVariables.put("name", "chenshun");

        User user = new User("chenshun", 50);
        restTemplate.put("http://HELLO-SERVICE-GROUP/hello/user3/{name}", user, uriVariables);
        System.out.println(">>>>>>>>>>>>>>>" + user.toString());
    }

    @RequestMapping(value = "/user7", method = RequestMethod.GET)
    public void user7() {
        Map<String, String> uriVariables = new HashMap<>(1);
        uriVariables.put("name", "chenshun");

        restTemplate.delete("http://HELLO-SERVICE-GROUP/hello/user4/{name}", uriVariables);
    }

}
