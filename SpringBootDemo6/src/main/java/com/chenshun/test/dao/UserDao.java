package com.chenshun.test.dao;

import com.chenshun.test.bean.User;
import com.chenshun.test.util.base.Page;

public interface UserDao {

    int insert(User roncooUser);

    int deleteById(int id);

    int updateById(User roncooUser);

    User selectById(int id);

    Page<User> queryForPage(int i, int j, String string);

}
