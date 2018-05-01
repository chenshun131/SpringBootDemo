package com.chenshun.consumer.bean;

/**
 * User: chenshun131 <p />
 * Time: 18/4/30 15:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class User {

    private String desc;

    private String name;

    public User() {
    }

    public User(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
