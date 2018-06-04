package com.chenshun.springbootdemo19.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * User: chenshun131 <p />
 * Time: 18/6/4 23:36  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
public class MyHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.debug(message.toString());
        // ...
    }

}
