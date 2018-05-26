package com.chenshun.test.util.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/5/26 11:20  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
@ConfigurationProperties("zuul.filter")
public class FilterConfiguration {

    private String root;

    private Integer interval;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

}
