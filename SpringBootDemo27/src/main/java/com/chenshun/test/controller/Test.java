package com.chenshun.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * User: chenshun131 <p />
 * Time: 18/9/20 08:42  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@RestController
public class Test {

    @RequestMapping
    public String showLog() {
        String logContent = "日志数据测试 : " + ThreadLocalRandom.current().nextInt();
        log.info(logContent);
        return logContent;
    }

}
