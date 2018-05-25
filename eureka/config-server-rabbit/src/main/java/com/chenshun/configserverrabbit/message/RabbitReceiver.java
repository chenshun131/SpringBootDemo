package com.chenshun.configserverrabbit.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 21:34  <p />
 * Version: V1.0  <p />
 * Description: 数据接收方 <p />
 */
@Slf4j
@Component
public class RabbitReceiver {

    /**
     * 接收队列中的消息，如果队列不存在则自动创建
     *
     * @param message
     */
    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void receive(String message) {
        log.debug("MyQueue = {}", message);
    }

    /**
     * 收队列中的消息，如果队列不存在则自动创建，另外还可以自动绑定 Exchange 和 Queue
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive2(String message) {
        log.debug("MyQueue = {}", message);
    }

}
