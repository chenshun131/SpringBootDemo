package com.chenshun.test.dao.impl;

import com.chenshun.test.bean.UserInfo;
import com.chenshun.test.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * User: chenshun131 <p />
 * Time: 18/4/19 22:54  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Component
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    @Override
    public void saveUser(UserInfo user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfo findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserInfo user = mongoTemplate.findOne(query, UserInfo.class);
        return user;
    }

    /**
     * 更新对象
     *
     * @param user
     */
    @Override
    public void updateUser(UserInfo user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        // 更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, UserInfo.class);
        // 更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserInfo.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, UserInfo.class);
    }

}
