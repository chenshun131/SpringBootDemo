package com.chenshun.configserverrabbit;

import com.chenshun.configserverrabbit.message.SinkSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: mew <p />
 * Time: 18/5/25 09:22  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private SinkSender sinkSender;

    @org.junit.Test
    public void sendOrder() {
        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder.withPayload("From Sender发送[" + i + "]").build();
            sinkSender.output().send(message);
        }
    }

}
