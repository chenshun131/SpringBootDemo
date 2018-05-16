package com.chenshun.provider.bean;

/**
 * User: mew <p />
 * Time: 18/4/26 13:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class User {

    private String name;

    private int age;

    private String type = "1111";

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "111 User{name='" + name + '\'' + ", age=" + age + '}';
    }

}
