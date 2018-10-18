package com.chenshun.test;

import java.time.LocalDate;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 14:55  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test2 {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2017,4,12);
        System.out.println(localDate1.isBefore(localDate2));  // 判断时间在什么时间之前
        System.out.println(localDate1.isAfter(localDate2)); // 判断时间在什么时间之后
        System.out.println(localDate1.isEqual(localDate2)); // 判断时间和什么时间相等
    }

}
