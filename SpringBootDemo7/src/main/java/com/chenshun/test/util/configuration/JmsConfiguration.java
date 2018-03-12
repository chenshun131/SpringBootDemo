package com.chenshun.test.util.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * User: mew <p />
 * Time: 18/3/12 10:07  <p />
 * Version: V1.0  <p />
 * Description: jms 队列配置 <p />
 */
@Configuration
public class JmsConfiguration {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("chenshun.queue");
    }

}
