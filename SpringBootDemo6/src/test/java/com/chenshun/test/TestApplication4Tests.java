package com.chenshun.test;

import com.chenshun.test.bean.UserLog;
import com.chenshun.test.dao.UserLogMongoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication4Tests {

    @Autowired
    private UserLogMongoDao userLogMongoDao;

    @Test
    public void insert() {
        UserLog entity = new UserLog();
        entity.setId(1);
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogMongoDao.save(entity);

        UserLog entityFind = new UserLog();
        entityFind.setId(1);

        Optional<UserLog> optional = userLogMongoDao.findOne(Example.of(entityFind));
        optional.ifPresent(System.out::println);
    }

    @Test
    public void delete() {
        UserLog entity = new UserLog();
        entity.setId(1);

        userLogMongoDao.delete(entity);
    }

    @Test
    public void update() {
        UserLog entity = new UserLog();
        entity.setId(2);
        entity.setUserName("无境2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogMongoDao.save(entity);
    }

    @Test
    public void select() {
        UserLog entity = new UserLog();
        entity.setId(1);

        Optional<UserLog> optional = userLogMongoDao.findOne(Example.of(entity));
        optional.ifPresent(System.out::println);
    }

    @Test
    public void select2() {
        UserLog result = userLogMongoDao.findByUserName("无境2");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by(new Sort.Order(Sort.Direction.DESC, "id")));
        // Page<UserLog> result = userLogDao.findByUserName("无境2", pageable);
        Page<UserLog> result = userLogMongoDao.findAll(pageable);
        System.out.println(result.getContent());
    }

}
