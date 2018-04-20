package com.chenshun.test.service;

import com.alibaba.fastjson.JSONObject;
import com.chenshun.test.bean.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * User: mew <p />
 * Time: 18/4/19 11:14  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service("mqProducer")
public class MQProducer {

    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * <B>方法名称：</B>发送邮件信息对象<BR>
     * <B>概要说明：</B>发送邮件信息对象<BR>
     *
     * @param mail
     */
    public void sendMessage(final Mail mail) {
        jmsTemplate.send(session -> session.createTextMessage(JSONObject.toJSONString(mail)));
    }

}
