package com.chenshun.test.dao;

import com.chenshun.test.bean.User;
import com.chenshun.test.util.base.Page;

/**
 * User: mew <p />
 * Time: 18/3/12 9:57  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface UserDao {

    int insert(User User);

    int deleteById(int id);

    int updateById(User User);

    User selectById(int id);

    Page<User> queryForPage(int i, int j, String string);

}
