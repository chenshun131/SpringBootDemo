package com.chenshun.configserverrabbit.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * User: mew <p />
 * Time: 18/5/25 09:18  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface SinkSender {

    @Output(Source.OUTPUT)
    MessageChannel output();

}
