package com.chenshun.test;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 14:43  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2018, 9, 27);
        MonthDay md1 = MonthDay.of(ld.getMonth(), ld.getDayOfMonth());
        System.out.println(md1); // --09-27

        MonthDay md2 = MonthDay.from(LocalDate.of(2018, 9, 27));
        System.out.println(md2); // --09-27

        if (md1.equals(md2)) { // equal
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

}
