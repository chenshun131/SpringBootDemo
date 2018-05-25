package com.chenshun.stream.util.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/5/25 11:17  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@EnableBinding(value = {Sink.class, SinkOutput.class})
public class SinkSender {

    /**
     * 以 2000 毫秒的频率向通道中发送数据
     *
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    /**
     * 接收反馈信息
     *
     * @param payload
     */
    @StreamListener(value = Source.OUTPUT)
    public void receive(String payload) {
        log.info("SinkSender Received: " + payload);
    }

}
