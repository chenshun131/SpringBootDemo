package com.chenshun.configserverrabbit.message;

import com.chenshun.configserverrabbit.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 22:29  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class SendMessage {

    @Autowired
    private StreamClient streamClient;

    public boolean send(Order order) {
        Message<Order> message = MessageBuilder.withPayload(order).build();
        return streamClient.output().send(message);
    }

}
