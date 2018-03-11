package com.chenshun.test.dao;

import com.chenshun.test.bean.User;

/**
 * User: mew <p />
 * Time: 18/3/10 15:55  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface UserDao {

    /**
     * 插入
     *
     * @param roncooUser
     * @return
     */
    int insert(User roncooUser);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 更新
     *
     * @param roncooUser
     * @return
     */
    int updateById(User roncooUser);

    /**
     * 查找
     *
     * @param id
     * @return
     */
    User selectById(int id);

}
