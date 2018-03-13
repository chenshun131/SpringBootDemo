package com.chenshun.test.mapper;

import com.chenshun.test.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * User: mew <p />
 * Time: 18/3/13 08:56  <p />
 * Version: V1.0  <p />
 * Description: <p />
 */
@Mapper
public interface UserMapper {

    @Insert(value = "insert into roncoo_user (name, create_time) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
    int insert(User record);

    @Select(value = "select id, name, create_time from roncoo_user where id = #{id,jdbcType=INTEGER}")
    @Results(value = {@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)})
    User selectByPrimaryKey(Integer id);

}
