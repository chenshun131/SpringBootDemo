package com.chenshun.test.service;

import com.chenshun.test.entity.Info;
import com.chenshun.test.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenshun131 <p />
 * Time: 18/10/13 12:03  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Service
@Slf4j
public class UserService {

    private Map<Long, User> userMap = new HashMap<>();

    private Map<Long, Info> infoMap = new HashMap<>();

    public UserService() {
        userMap.put(1L, new User(1L, "aaa", "666666"));
        userMap.put(2L, new User(2L, "bbb", "666666"));
        userMap.put(3L, new User(3L, "ccc", "666666"));
        infoMap.put(1L, new Info("18559198715", "福州市"));
    }

    public List list() {
        return Arrays.asList(userMap.values().toArray());
    }

    @Cacheable(value = "user", key = "'user'.concat(#id.toString())")
    public User findUserById(Long id) {
        log.info("findUserById query from db, id: {}", id);
        return userMap.get(id);
    }

    @Cacheable(value = "info", key = "'info'.concat(#id.toString())")
    public User findInfoById(Long id) {
        log.info("findInfoById query from db, id: {}", id);
        return userMap.get(id);
    }

    @CachePut(value = "user", key = "'user'.concat(#user.id.toString())")
    public void update(User user) {
        log.info("update db, user: {}", user.toString());
        userMap.put(user.getId(), user);
    }

    @CacheEvict(value = "user", key = "'user'.concat(#id.toString())")
    public void remove(Long id) {
        log.info("remove from db, id: {}", id);
        userMap.remove(id);
    }

}
