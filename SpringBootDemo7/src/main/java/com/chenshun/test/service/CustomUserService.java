package com.chenshun.test.service;

import com.chenshun.test.bean.SysUser;
import com.chenshun.test.dao.SysUserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * User: mew <p />
 * Time: 18/3/13 14:00  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class CustomUserService implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

}
