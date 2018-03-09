package com.chenshun.test.bean;

import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/8 15:59  <p />
 * Version: V1.0  <p />
 * Description: 实体类 <p />
 */
public class User {

    private int id;

    private String name;

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
