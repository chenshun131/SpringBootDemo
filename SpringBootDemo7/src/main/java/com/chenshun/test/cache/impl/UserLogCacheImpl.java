package com.chenshun.test.cache.impl;

import com.chenshun.test.bean.UserLog;
import com.chenshun.test.cache.UserLogCache;
import com.chenshun.test.dao.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User: mew <p />
 * Time: 18/3/11 11:30  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@CacheConfig(cacheNames = "myCache")
@Repository
public class UserLogCacheImpl implements UserLogCache {

    @Autowired
    private UserLogDao userLogDao;

    @Cacheable(key = "#p0+#p1")
    @Override
    public UserLog selectById(Integer id, String name) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" + id);

        UserLog userLog = new UserLog();
        userLog.setId(id);

        Optional<UserLog> optional = userLogDao.findOne(Example.of(userLog));
        return optional.orElse(new UserLog());
    }

    @CachePut(key = "#p0")
    @Override
    public UserLog updateById(UserLog userLog) {
        System.out.println("更新功能，更新缓存，直接写库, id=" + userLog);
        return userLogDao.save(userLog);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Integer id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        return "清空缓存成功";
    }

    @Cacheable(key = "#p0")
    @Override
    public String get1(int i) {
        return "name1";
    }

    @Cacheable(key = "#p0")
    @Override
    public String get2(int i) {
        return "name2";
    }

}
