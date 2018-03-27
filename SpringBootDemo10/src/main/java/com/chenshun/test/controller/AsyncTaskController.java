package com.chenshun.test.controller;

import com.chenshun.test.service.AsynTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: mew <p />
 * Time: 18/3/27 17:32  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RestController
@RequestMapping
public class AsyncTaskController {

    @Autowired
    private AsynTaskService asynTaskService;

    @RequestMapping
    public String doTask() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        asynTaskService.task1();
        asynTaskService.task2();
        asynTaskService.task3();
        long currentTimeMillis1 = System.currentTimeMillis();
        return "task任务总耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms";
    }

}
