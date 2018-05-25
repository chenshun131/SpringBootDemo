package com.chenshun.stream.util.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/5/19 15:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@EnableBinding({Sink.class, Source.class})
public class SinkReceiver {

    @StreamListener(value = Sink.INPUT)
    @SendTo(value = Source.OUTPUT)
    public void receive(String payload) {
        log.info("SinkReceiver Received: " + payload);
    }

    /**
     * 对通道中的数据进行转换
     *
     * @param message
     * @return
     */
    @Transformer(inputChannel = Sink.INPUT, outputChannel = Source.OUTPUT)
    public String transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

}
