package com.chenshun.test.dao;

import com.chenshun.test.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: mew <p />
 * Time: 18/3/13 13:57  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {

    /**
     * 根据用户名查用户
     *
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

}
