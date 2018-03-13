package com.chenshun.test.mapper;

import com.chenshun.test.bean.RoncooUser;
import com.chenshun.test.bean.RoncooUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoncooUserMapper {

    int countByExample(RoncooUserExample example);

    int deleteByExample(RoncooUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoncooUser record);

    int insertSelective(RoncooUser record);

    List<RoncooUser> selectByExample(RoncooUserExample example);

    RoncooUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);

    int updateByExample(@Param("record") RoncooUser record, @Param("example") RoncooUserExample example);

    int updateByPrimaryKeySelective(RoncooUser record);

    int updateByPrimaryKey(RoncooUser record);

}
