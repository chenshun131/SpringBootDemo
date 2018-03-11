package com.chenshun.test.dao;

import com.chenshun.test.bean.User;
import com.chenshun.test.util.base.Page;

/**
 * User: mew <p />
 * Time: 18/3/10 13:43  <p />
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

    /**
     * 分页查找数据
     *
     * @return
     */
    Page<User> queryForPage(int pageCurrent, int pageSize, String name);

}
