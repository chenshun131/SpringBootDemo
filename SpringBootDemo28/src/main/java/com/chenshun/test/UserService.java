package com.chenshun.test;

import com.chenshun.test.model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: chenshun131 <p />
 * Time: 18/9/6 06:56  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface UserService {

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    User login(String name, String password);

}
