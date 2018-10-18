package com.chenshun.test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

/**
 * User: chenshun131 <p />
 * Time: 18/10/11 11:18  <p />
 * Version: V1.0  <p />
 * Description:  <p />
 */
public class Test {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        System.out.println("getStartDate : " + sdf.format(getStartDate(date, -1)));
        System.out.println("getEndDate : " + sdf.format(getEndDate(date, -1)));
        System.out.println("getStartWeekStartDate : " + sdf.format(getStartWeekStartDate(date)));
        System.out.println("getEndWeekEndDate : " + sdf.format(getEndWeekEndDate(date)));
        System.out.println("getStartMounthStartDate : " + sdf.format(getStartMounthStartDate(date)));
        System.out.println("getEndMounthEndDate : " + sdf.format(getEndMounthEndDate(date)));
    }

    /**
     * 获得当天的起始时间
     *
     * @param date
     * @param plusDays
     *         增加的天数
     * @return
     */
    public static Date getStartDate(Date date, long plusDays) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        localDateTime = localDateTime.plusDays(plusDays);
        Instant instant = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取当天截止时间
     *
     * @param date
     * @param plusDays
     *         增加的天数
     * @return
     */
    public static Date getEndDate(Date date, long plusDays) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        localDateTime = localDateTime.plusDays(plusDays);
        Instant instant = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 获得当月起始时间
     *
     * @return
     */
    public static Date getStartWeekStartDate(Date date) {
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
        Instant instant = LocalDateTime.of(localDate, LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 获得当月结束时间
     *
     * @return
     */
    public static Date getEndWeekEndDate(Date date) {
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7);
        Instant instant = LocalDateTime.of(localDate, LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 获得当月起始时间
     *
     * @return
     */
    public static Date getStartMounthStartDate(Date date) {
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.with(TemporalAdjusters.firstDayOfMonth());
        Instant instant = LocalDateTime.of(localDate, LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 获得当月结束时间
     *
     * @return
     */
    public static Date getEndMounthEndDate(Date date) {
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.with(TemporalAdjusters.lastDayOfMonth());
        Instant instant = LocalDateTime.of(localDate, LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

}
