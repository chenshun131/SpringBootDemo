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
     * @param roncooUserLog
     * @return
     */
    UserLog updateById(UserLog roncooUserLog);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Integer id);

}
