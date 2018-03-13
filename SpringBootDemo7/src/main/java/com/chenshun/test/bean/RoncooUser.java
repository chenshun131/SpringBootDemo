package com.chenshun.test.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/13 10:49  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class RoncooUser implements Serializable {

    private static final long serialVersionUID = 2087533104554706180L;

    private Integer id;

    private String name;

    private Date createTime;

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
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoncooUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}
