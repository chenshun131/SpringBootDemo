package com.chenshun.stream.util.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * User: mew <p />
 * Time: 18/5/25 11:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface SinkOutput {

    @Output(Source.OUTPUT)
    MessageChannel output();

}
