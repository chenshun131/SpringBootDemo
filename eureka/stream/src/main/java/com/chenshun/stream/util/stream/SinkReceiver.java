package com.chenshun.stream.util.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * User: chenshun131 <p />
 * Time: 18/5/19 15:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    private Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: " + payload);
    }

}
