package com.chenshun.consumer.service;

import com.chenshun.consumer.bean.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * User: chenshun131 <p />
 * Time: 18/5/1 14:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public User find(Long id) {
        return restTemplate.getForObject("http://HELLO-SERVICE-GROUP/hello/user2?id={1}", User.class, id);
    }

    public List findAll(List<Long> ids) {
        return restTemplate.getForObject("http://HELLO-SERVICE-GROUP/hello/user2?ids={1}", List.class, StringUtils.join(ids, ","));
    }

}
