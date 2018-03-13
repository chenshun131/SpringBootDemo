package com.chenshun.test.mapper;

import com.chenshun.test.bean.RoncooUserLog;
import com.chenshun.test.bean.RoncooUserLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoncooUserLogMapper {

    int countByExample(RoncooUserLogExample example);

    int deleteByExample(RoncooUserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoncooUserLog record);

    int insertSelective(RoncooUserLog record);

    List<RoncooUserLog> selectByExample(RoncooUserLogExample example);

    RoncooUserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoncooUserLog record, @Param("example") RoncooUserLogExample example);

    int updateByExample(@Param("record") RoncooUserLog record, @Param("example") RoncooUserLogExample example);

    int updateByPrimaryKeySelective(RoncooUserLog record);

    int updateByPrimaryKey(RoncooUserLog record);

}
