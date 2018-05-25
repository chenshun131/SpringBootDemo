package com.chenshun.configserverrabbit.message;

import com.chenshun.configserverrabbit.bean.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/23 22:27  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
@EnableBinding(value = {StreamClient.class})
@Component
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
//    @SendTo(StreamClient.OUTPUT)
    public void receive(Order order) {
        if (order != null) {
            log.debug("StreamReceiver : {}", order.toString());
        }
    }

}
