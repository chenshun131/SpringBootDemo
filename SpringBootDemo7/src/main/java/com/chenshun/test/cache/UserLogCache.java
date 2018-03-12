package com.chenshun.test.cache;

import com.chenshun.test.bean.UserLog;

/**
 * User: mew <p />
 * Time: 18/3/11 11:31  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface UserLogCache {

    /**
     * 查询
     *
     * @param id
     * @param name
     * @return
     */
    UserLog selectById(Integer id, String name);

    /**
     * 更新
     *
     * @param userLog
     * @return
     */
    UserLog updateById(UserLog userLog);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Integer id);

    String get1(int i);

    String get2(int i);

}
