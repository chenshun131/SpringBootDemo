package com.chenshun.test;

import java.time.LocalDateTime;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 14:50  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test1 {

    public static void main(String[] args) {
        LocalDateTime newLdt = LocalDateTime.now();
        System.out.println(newLdt); // 2018-09-27T14:51:33.457
        System.out.println(newLdt.getHour()); // 14
        System.out.println(newLdt.getMinute()); // 51
        System.out.println(newLdt.getSecond()); // 33

        LocalDateTime newLdt2 = newLdt.plusHours(3).plusMinutes(40).plusSeconds(10);
        System.out.println(newLdt2); // 2018-09-27T18:31:43.457
    }

}
