package com.chenshun.test.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * User: chenshun131 <p />
 * Time: 18/10/7 12:44  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Slf4j
public class MqttPushClient {

    private static MqttClient client;

    public static MqttClient getClient() {
        return client;
    }

    public static void setClient(MqttClient client) {
        MqttPushClient.client = client;
    }

    public void connect(String host, String clientid, String username, String password, int timeout, int keepalive) {
        MqttClient client;
        try {
            // MemoryPersistence 设置 clientid 的保存形式，默认为以内存保存
            client = new MqttClient(host, clientid, new MemoryPersistence());
            // MQTT的连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            // 设置是否清空session，这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            // 设置连接的用户名
            options.setUserName(username);
            // 设置连接的密码
            options.setPassword(password.toCharArray());
            // 设置超时时间，单位为秒
            options.setConnectionTimeout(timeout);
            // 设置会话心跳时间，单位为秒，服务器会每隔 1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(keepalive);
            MqttPushClient.setClient(client);
            try {
                client.setCallback(new PushCallback());

//                MqttTopic topic = client.getTopic(TOPIC1);
//                // setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
//                options.setWill(topic, "close".getBytes(), 2, true);

                client.connect(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布，默认qos为0，非持久化
     *
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic, PushPayload pushMessage) {
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     *
     * @param qos
     *         三种消息可能性保障(Qos): 0:最多一次 1:最少一次 2:只有一次
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public void publish(int qos, boolean retained, String topic, PushPayload pushMessage) {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.toString().getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if (null == mTopic) {
            log.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic
     * @param qos
     *         三种消息可能性保障(Qos): 0:最多一次 1:最少一次 2:只有一次
     */
    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
