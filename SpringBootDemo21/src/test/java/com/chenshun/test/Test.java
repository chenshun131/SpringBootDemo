package com.chenshun.test;

import com.chenshun.test.bean.GoodInfoBean;
import com.chenshun.test.bean.GoodTypeBean;
import com.chenshun.test.mapper.GoodInfoMapper;

/**
 * User: chenshun131 <p />
 * Time: 18/10/26 11:25  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test {

    public static void main(String[] args) {
        // 查询商品基本信息
        GoodInfoBean goodInfoBean = new GoodInfoBean(1L, "title", 1, 1, 1L);
        // 查询商品类型基本信息
        GoodTypeBean typeBean = new GoodTypeBean(2L, "name", 2, 2);
        System.out.println(GoodInfoMapper.MAPPER.from(goodInfoBean, typeBean).toString());
    }

}
