package com.chenshun.test.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User: mew <p />
 * Time: 18/3/13 13:51  <p />
 * Version: V1.0  <p />
 * Description: 角色 <p />
 */
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

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

}
