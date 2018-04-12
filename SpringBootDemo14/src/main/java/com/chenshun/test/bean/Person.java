package com.chenshun.test.bean;

import javax.validation.constraints.Size;

/**
 * User: mew <p />
 * Time: 18/4/11 15:38  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Person {

    /** 1此处使用JSR-303注解来校验数据 */
    @Size(max = 4, min = 2)
    private String name;

    private int age;

    private String nation;

    private String address;

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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
