package com.chenshun.test.bean;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/8 12:36  <p />
 * Version: V1.0  <p />
 * Description: 实体类 <p />
 */
public class User {

    private int id;

    private String name;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "RoncooUser [id=" + id + ", name=" + name + ", createTime=" + createTime + "]";
    }

}
