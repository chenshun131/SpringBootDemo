package com.chenshun.configserverrabbit.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * User: mew <p />
 * Time: 18/5/25 09:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(String payload) {
        log.debug("Received : {}", payload);
    }

}
