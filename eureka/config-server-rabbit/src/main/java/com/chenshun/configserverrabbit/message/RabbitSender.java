package com.chenshun.configserverrabbit.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 21:37  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @param queue
     * @param msg
     */
    public void send(String queue, String msg) {
        amqpTemplate.convertAndSend(queue, msg);
        log.debug("消费发送成功 {}", msg);
    }

    public void send(String exchange, String queue, String msg) {
        amqpTemplate.convertAndSend(exchange, queue, msg);
        log.debug("消费发送成功 {}", msg);
    }

}
