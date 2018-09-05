package com.chenshun.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        // 创建这个订单流程，根据之前的定义，该订单会处于待支付状态
        stateMachine.start();
        // 执行支付操作
        stateMachine.sendEvent(Events.PAY);
        // 完成收货操作
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
