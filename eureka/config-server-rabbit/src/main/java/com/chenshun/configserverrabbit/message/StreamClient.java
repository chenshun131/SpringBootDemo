package com.chenshun.configserverrabbit.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 22:24  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface StreamClient {

    String INPUT = "input";

    String OUTPUT = "output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
