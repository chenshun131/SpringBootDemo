package com.chenshun.springannotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * 数据库脚本
 * CREATE TABLE tbl_user(id INT PRIMARY KEY AUTO_INCREMENT,username VARCHAR(50),age INT)
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO tbl_user(username,age) VALUES(?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql, username, 19);
    }

}
