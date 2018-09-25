package com.chenshun.test.dao;

import com.chenshun.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * User: chenshun131 <p />
 * Time: 18/9/6 06:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("FROM User u WHERE u.name=:name")
    User findUser(@Param("name") String name);

}
