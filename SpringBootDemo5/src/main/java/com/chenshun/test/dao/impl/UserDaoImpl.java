package com.chenshun.test.dao.impl;

import com.chenshun.test.bean.User;
import com.chenshun.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * User: mew <p />
 * Time: 18/3/10 15:54  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into roncoo_user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime());
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from roncoo_user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(User user) {
        String sql = "update roncoo_user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime(), user.getId());
    }

    @Override
    public User selectById(int id) {
        String sql = "select * from roncoo_user where id=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setCreateTime(rs.getDate("create_time"));
            return user;
        }, id);
    }

}
