package com.chenshun.test.dao;

import com.chenshun.test.bean.UserInfo;

/**
 * User: chenshun131 <p />
 * Time: 18/4/19 22:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface UserInfoDao {

    void saveUser(UserInfo user);

    UserInfo findUserByUserName(String userName);

    void updateUser(UserInfo user);

    void deleteUserById(Long id);

}
