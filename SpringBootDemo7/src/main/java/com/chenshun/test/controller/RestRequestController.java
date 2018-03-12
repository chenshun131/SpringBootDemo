package com.chenshun.test.controller;

import com.chenshun.test.bean.UserLog;
import com.chenshun.test.cache.UserLogCache;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/12 14:24  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestRequestController {

    @Autowired
    private UserLogCache userLogCache;

    @RequestMapping(value = "/update")
    public UserLog update(@RequestBody JsonNode jsonNode) {
        System.out.println("jsonNode=" + jsonNode);
        UserLog bean = userLogCache.selectById(jsonNode.get("id").asInt(1), "name_update");
        if (bean == null) {
            bean = new UserLog();
        }
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");

        userLogCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public UserLog update2(@PathVariable(value = "id") Integer id) {
        UserLog bean = userLogCache.selectById(id, "name_update2");
        if (bean == null) {
            bean = new UserLog();
        }
        bean.setUserName("测试");
        bean.setCreateTime(new Date());
        bean.setUserIp("192.168.1.1");

        userLogCache.updateById(bean);
        return bean;
    }

}
