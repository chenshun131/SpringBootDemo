package com.chenshun.test.bean;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/4/4 16:47  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class A {

    private Integer id;

    private String name;

    private Date createTime;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
