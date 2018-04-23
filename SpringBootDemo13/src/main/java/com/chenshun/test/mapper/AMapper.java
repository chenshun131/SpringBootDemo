package com.chenshun.test.mapper;

import com.chenshun.test.bean.A;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User: mew <p />
 * Time: 18/4/4 16:48  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
@Mapper
public interface AMapper {

    int insert(List<A> list);

//    int insert(A list);

}
