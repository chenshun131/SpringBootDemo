package com.chenshun.test;

import com.chenshun.test.util.SerializationUtil;

/**
 * User: chenshun131 <p />
 * Time: 18/10/18 23:39  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test1 {

    public static void main(String[] args) {
        String tag = ":login:image123123123code";
        byte[] serial = SerializationUtil.serialize(tag);
        String store1 = SerializationUtil.deserialize(serial, String.class);
        System.out.println(String.valueOf(serial));
        System.out.println(store1.toString());
    }

}
