package com.chenshun.test.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/8/2 11:36  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class PrintTask {

    @Scheduled(initialDelay = 1000 * 10, cron = "0 * * * * ?")
    public void cron() {
        System.out.println("执行测试时间 : " + new Date());
    }

}
