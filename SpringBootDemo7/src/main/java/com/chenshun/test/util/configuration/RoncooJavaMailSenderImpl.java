package com.chenshun.test.util.configuration;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * User: mew <p />
 * Time: 18/3/12 15:18 <p />
 * Version: V1.0  <p />
 * Description: 实现多账号，轮询发送 <p />
 */
@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class RoncooJavaMailSenderImpl extends JavaMailSenderImpl implements JavaMailSender {

    private ArrayList<String> usernameList;

    private ArrayList<String> passwordList;

    private int currentMailId = 0;

    private final MailProperties properties;

    public RoncooJavaMailSenderImpl(MailProperties properties) {
        this.properties = properties;
        // 初始化账号
        if (usernameList == null) {
            usernameList = new ArrayList<>();
        }
        String[] userNames = properties.getUsername().split(",");
        usernameList.addAll(Arrays.asList(userNames));

        // 初始化密码
        if (passwordList == null) {
            passwordList = new ArrayList<>();
        }
        String[] passwords = this.properties.getPassword().split(",");
        passwordList.addAll(Arrays.asList(passwords));
    }

    @Override
    protected void doSend(MimeMessage[] mimeMessage, Object[] object) throws MailException {
        super.setUsername(usernameList.get(currentMailId));
        super.setPassword(passwordList.get(currentMailId));

        // 设置编码和各种参数
        super.setHost(this.properties.getHost());
        super.setDefaultEncoding(this.properties.getDefaultEncoding().name());
        super.setJavaMailProperties(asProperties(this.properties.getProperties()));
        super.doSend(mimeMessage, object);

        // 轮询
        currentMailId = (currentMailId + 1) % usernameList.size();
    }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }

    @Override
    public String getUsername() {
        return usernameList.get(currentMailId);
    }

}
