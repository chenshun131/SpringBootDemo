package com.chenshun.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * User: chenshun131 <p />
 * Time: 18/9/27 15:01  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test3 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2018, 9, 27);
        System.out.println(localDate); // 2018-09-27

        // 下一个星期天
        LocalDate newdata = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(newdata); // 2018-09-30

        // 这个月的最后一天
        LocalDate lastDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDate); // 2018-09-30

        // 表示当前月的第二周的星期天
        LocalDate date1 = localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
        System.out.println(date1); // 2018-09-09

        // 当前月的第一天
        LocalDate date2 = localDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date2); // 2018-09-01

        // 下个月的第一天
        LocalDate date3 = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(date3); // 2018-10-01

        // 明年的第一天
        LocalDate date4 = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(date4); // 2019-01-01

        // 今年的第一天
        LocalDate date5 = localDate.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(date5); // 2018-01-01

        // 本月第一个星期三的日期
        LocalDate date6 = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));
        System.out.println(date6); // 2018-09-05

        // 今年的最后一天
        LocalDate date7 = localDate.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(date7); // 2018-12-31

        // 当月最后一个星期二的日期
        LocalDate date8 = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));
        System.out.println(date8); // 2018-09-25

        // 下个星期天的日期
        LocalDate date9 = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(date9); // 2018-09-30
        System.out.println("localDate=======" + localDate); // localDate=======2018-09-27
        LocalDate localDate2 = LocalDate.of(2017, 6, 20);
        LocalDate date13 = localDate2.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date13); // 2017-06-25
        System.out.println("localDate2===" + localDate2); // localDate2===2017-06-20

        // 上个星期天的日期，不可以是今天
        LocalDate date10 = localDate.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        System.out.println(date10); // 2018-09-23

        // 上个星期天的日期，可以是今天
        LocalDate date11 = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        System.out.println(date11); // 2018-09-23

        LocalDate localDate1 = LocalDate.of(2017, 6, 7); // 为本月第一个星期三
        LocalDate date12 = localDate1.with(TemporalAdjusters.previousOrSame(DayOfWeek.WEDNESDAY));
        System.out.println(date12); // 2017-06-07
    }

}
