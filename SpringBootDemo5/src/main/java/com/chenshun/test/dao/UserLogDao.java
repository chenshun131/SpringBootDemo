package com.chenshun.test.dao;

import com.chenshun.test.bean.UserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * User: mew <p />
 * Time: 18/3/8 12:36  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface UserLogDao extends JpaRepository<UserLog, Integer> {

    /**
     * @param userName
     * @return
     */
    @Query(value = "select u from UserLog u where u.userName=?1")
    List<UserLog> findByUserName(String userName);

    /**
     * @param string
     * @param string2
     * @return
     */
    List<UserLog> findByUserNameAndUserIp(String string, String string2);

    /**
     * @param userName
     * @param pageable
     * @return
     */
    Page<UserLog> findByUserName(String userName, Pageable pageable);

}
