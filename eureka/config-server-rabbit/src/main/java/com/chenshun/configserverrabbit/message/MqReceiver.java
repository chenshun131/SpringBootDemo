package com.chenshun.configserverrabbit.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 21:57  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@Component
public class MqReceiver {

    /**
     * 电脑订单
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        log.debug("computer MQReceiver : {}", message);
    }

    /**
     * 水果订单
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        log.debug("fruit MQReceiver : {}", message);
    }

}
