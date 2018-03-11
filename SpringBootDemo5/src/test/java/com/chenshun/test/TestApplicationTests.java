package com.chenshun.test;

import com.chenshun.test.bean.UserLog;
import com.chenshun.test.dao.UserLogDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private UserLogDao userLogDao;

    @Test
    public void insert() {
        UserLog entity = new UserLog();
        entity.setUserName("无境");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogDao.save(entity);
    }

    @Test
    public void delete() {
        UserLog entity = new UserLog();
        entity.setId(1);

        userLogDao.delete(entity);
    }

    @Test
    public void update() {
        UserLog entity = new UserLog();
        entity.setId(2);
        entity.setUserName("无境2");
        entity.setUserIp("192.168.0.1");
        entity.setCreateTime(new Date());
        userLogDao.save(entity);
    }

    @Test
    public void select() {
        UserLog entity = new UserLog();
        entity.setId(1);

        Optional<UserLog> result = userLogDao.findOne(Example.of(entity));
        result.ifPresent(System.out::println);
    }

    @Test
    public void select2() {
        List<UserLog> result = userLogDao.findByUserName("无境");
        System.out.println(result);
    }

    @Test
    public void select3() {
        List<UserLog> result = userLogDao.findByUserNameAndUserIp("无境", "192.168.0.1");
        System.out.println(result);
    }

    // 分页
    @Test
    public void queryForPage() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by(new Sort.Order(Direction.DESC, "id")));
        Page<UserLog> result = userLogDao.findByUserName("无境", pageable);
        System.out.println(result.getContent());
    }

}
