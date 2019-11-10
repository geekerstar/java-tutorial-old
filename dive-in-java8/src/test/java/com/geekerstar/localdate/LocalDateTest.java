package com.geekerstar.localdate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * @author geekerstar
 * date: 2019/11/10 09:57
 * description:
 *
 * LocalDate是一个不可变类，在不考虑时区的情况下可以对日期（不包括时间）进行各种操作，它的默认格式是yyyy-MM-dd
 *
 * LocalTime与LocalDate一样，也是一个不可变的类，默认格式是hh:mm:ss.zzz，它提供了对时间的各种操作
 *
 * LocalDateTime是一个不可变的日期-时间对象，它既包含了日期同时又含有时间，默认格式是yyyy-MM-ddTHH-mm-ss.zzz
 */
public class LocalDateTest {

    @Test
    public void LocalDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate of = LocalDate.of(2019, 1, 12);
        System.out.println(of);

        int year = now.getYear();
        int i = now.get(ChronoField.YEAR);
        Month month = now.getMonth();
        int i1 = now.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth = now.getDayOfMonth();
        int i2 = now.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int i3 = now.get(ChronoField.DAY_OF_WEEK);
        System.out.println(year+" "+i+" "+month+" "+i1+" "+dayOfMonth+" "+i2+" "+dayOfWeek+" "+i3);

    }

    @Test
    public void LocalTime(){
        LocalTime of = LocalTime.of(12, 12, 12);
        LocalTime now = LocalTime.now();

        //获取小时
        int hour = now.getHour();
        int hour1 = now.get(ChronoField.HOUR_OF_DAY);
        // 获取分
        int minute = now.getMinute();
        int minute1 = now.get(ChronoField.MINUTE_OF_HOUR);
        // 获取秒
        int second = now.getSecond();
        int second1 = now.get(ChronoField.SECOND_OF_MINUTE);

        System.out.println(hour+" "+hour1+" "+minute+" "+minute1+" "+second+" "+second1);

    }

    @Test
    public void LocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 56, 44);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime2 = localDate.atTime(localTime);
        LocalDateTime localDateTime3 = localTime.atDate(localDate);
        // 获取LocalDate
        LocalDate localDate1 = localDateTime1.toLocalDate();
        // 获取LocalTime
        LocalTime localTime1 = localDateTime1.toLocalTime();

        System.out.println(localDateTime1+" "+localDateTime2+" "+localDateTime3+" "+localDate1+" "+localTime1);

    }

    @Test
    public void instant(){
        Instant instant = Instant.now();
        // 获取秒数
        long epochSecond = instant.getEpochSecond();
        // 获取毫秒数
        long toEpochMilli = instant.toEpochMilli();

        System.out.println(epochSecond+" "+toEpochMilli);

    }

    //LocalDate、LocalTime、LocalDateTime、Instant为不可变对象，修改这些对象对象会返回一个副本

    @Test
    public void modify(){
        LocalDateTime now = LocalDateTime.now();
        // 增加一年
        LocalDateTime date1 = now.plusYears(1);
        LocalDateTime date2 = now.plus(1, ChronoUnit.YEARS);
        // 减少一个月
        LocalDateTime date3 = now.minusMonths(1);
        LocalDateTime date4 = now.minus(1, ChronoUnit.MONTHS);

        // with修改某些值
        LocalDateTime date5 = now.withYear(2020);
        LocalDateTime date6 = now.with(ChronoField.YEAR, 2022);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);
    }

    @Test
    public void calcTime(){
        // 时间计算
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.with(firstDayOfYear());
        System.out.println(localDate);

        // 格式化时间
        LocalDate localDate1 = LocalDate.of(2019, 10, 10);
        String s1 = localDate1.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate1.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // 自定义格式化(MM大写)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // 解析时间 和SimpleDateFormat相比，DateTimeFormatter是线程安全的
        LocalDate l1 = LocalDate.parse("20190101", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate l2 = LocalDate.parse("2019-01-01", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(l1);
        System.out.println(l2);

        LocalDate localDate11 = LocalDate.now();
        System.out.println("2年后日期：" + localDate11.plusYears(2));
        System.out.println("6月后日期：" + localDate11.plusMonths(6));
        System.out.println("3周后日期：" + localDate11.plusWeeks(3));
        System.out.println("15天后日期：" + localDate11.plusDays(15));
        System.out.println("2年前日期：" + localDate11.minusYears(2));
        System.out.println("6月前日期：" + localDate11.minusMonths(6));
        System.out.println("3周前日期：" + localDate11.minusWeeks(3));
        System.out.println("15天前日期：" + localDate11.minusDays(15));

        //获取某年份的第N天的日期
        LocalDate specialDay = LocalDate.ofYearDay(2018, 100);
        System.out.println("2018年的第100天：" + specialDay);
//获取两个日期的间隔天数
        long intervalDay = localDate.toEpochDay() - specialDay.toEpochDay();
        System.out.println("间隔天数： " + intervalDay);



    }

    @Test
    public void compareDate(){
        LocalDate localDate = LocalDate.now();
        LocalDate otherDate = LocalDate.of(2018, 11, 11);
//equals方法用于比较两个日期是否相等
        if(localDate.equals(otherDate)) {
            System.out.println("localDate与otherDate相等！");
        } else {
            //isAfter和isBefore方法用于比较两个日期前后顺序
            if(localDate.isAfter(otherDate)) {
                System.out.println("localDate晚于otherDate！");
            }
            if(localDate.isBefore(otherDate)) {
                System.out.println("localDate早于otherDate！");
            }
        }

    }
}
