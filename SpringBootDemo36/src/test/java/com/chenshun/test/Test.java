package com.chenshun.test;

import com.chenshun.test.model.Store;
import com.chenshun.test.util.SerializationUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: chenshun131 <p />
 * Time: 18/10/18 23:21  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test {

    public static void main(String[] args) {
        Store store = new Store("str1", "str2", new BigDecimal(1), new BigDecimal(2),
                1, 2, new Date(), new Date());
        byte[] serial = SerializationUtil.serialize(store);
        Store store1 = SerializationUtil.deserialize(serial, Store.class);
        System.out.println(String.valueOf(serial));
        System.out.println(store1.toString());
    }

}
