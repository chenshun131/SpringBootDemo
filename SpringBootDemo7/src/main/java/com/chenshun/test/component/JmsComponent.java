package com.chenshun.test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * User: mew <p />
 * Time: 18/3/12 9:50  <p />
 * Version: V1.0  <p />
 * Description: JMS <p />
 */
@Component
public class JmsComponent {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @JmsListener(destination = "chenshun.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

}
