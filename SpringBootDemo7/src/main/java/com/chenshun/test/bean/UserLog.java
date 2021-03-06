package com.chenshun.test.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * User: mew <p />
 * Time: 18/3/11 11:28  <p />
 * Version: V1.0  <p />
 * Description: 实体类 <p />
 */
@Entity
public class UserLog implements Serializable {

    private static final long serialVersionUID = 6291026143789380914L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Date createTime;

    @Column
    private String userName;

    @Column
    private String userIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Override
    public String toString() {
        return "RoncooUserLog [id=" + id + ", createTime=" + createTime + ", userName=" + userName + ", userIp=" + userIp + "]";
    }

}
