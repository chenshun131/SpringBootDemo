package com.chenshun.consumer.bean;

import java.io.Serializable;

/**
 * User: mew <p />
 * Time: 18/4/26 13:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8534200423762353042L;

    private String name;

    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
