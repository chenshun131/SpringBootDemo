package com.chenshun.test.dao;

import com.chenshun.test.bean.UserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: mew <p />
 * Time: 18/3/12 9:54  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
public interface UserLogMongoDao extends MongoRepository<UserLog, Integer> {

    UserLog findByUserName(String string);

    UserLog findByUserNameAndUserIp(String string, String ip);

    Page<UserLog> findByUserName(String string, Pageable pageable);

}
