package com.chenshun.test.controller;

import com.chenshun.test.bean.RoncooUser;
import com.chenshun.test.mapper.RoncooUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "api操作工具方法")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private RoncooUserMapper roncooUserMappper;

    @ApiOperation(value = "查找", notes = "根据用户ID查找用户")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public RoncooUser get(@RequestParam(defaultValue = "1") Integer id) {
        return roncooUserMappper.selectByPrimaryKey(id);
    }

    @ApiIgnore
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public int delete(@RequestParam(defaultValue = "1") Integer id) {
        return roncooUserMappper.deleteByPrimaryKey(id);
    }

}
