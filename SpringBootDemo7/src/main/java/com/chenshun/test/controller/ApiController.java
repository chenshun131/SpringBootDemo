package com.chenshun.test.controller;

import com.chenshun.test.bean.UserLog;
import com.chenshun.test.cache.UserLogCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * User: mew <p />
 * Time: 18/3/11 11:39  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserLogCache userLogCache;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public UserLog get(@RequestParam(defaultValue = "1") Integer id, @RequestParam(defaultValue = "") String name) {
        return userLogCache.selectById(id, name);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public UserLog update(@RequestParam(defaultValue = "1") Integer id, @RequestParam(defaultValue = "") String name) {
        UserLog bean = userLogCache.selectById(id, name);
        bean.setUserName("测试");
        bean.setCreateTime(new Date());

        userLogCache.updateById(bean);
        return bean;
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(@RequestParam(defaultValue = "1") Integer id) {
        return userLogCache.deleteById(id);
    }

    @RequestMapping(value = "/get1")
    public String get1() {
        return userLogCache.get1(1);
    }

    @RequestMapping(value = "/get2")
    public String get2() {
        return userLogCache.get2(1);
    }

}
