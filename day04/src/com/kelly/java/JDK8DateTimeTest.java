package com.kelly.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/18 15:04
 */
public class JDK8DateTimeTest
{
    @Test
    public void testDate()
    {
        //偏移量
//        Date date1 = new Date(2020 - 1900,9 - 1,8);
//        System.out.println(date1);//Fri Oct 08 00:00:00 CST 3920
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明;
         1.LocalDateTime相较于LocalDate、LocalTime使用频率要高一些
         2.类似于Calendar
     */
    @Test
    public void test1()
    {
        //now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2021-01-18
        System.out.println(localTime);//15:36:09.830
        System.out.println(localDateTime);//2021-01-18T15:36:09.830

        //of()：设置指定的年、月、日、时、分、秒且没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);//2020-10-06T13:23:43

        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//18
        System.out.println(localDateTime.getDayOfWeek());//MONDAY
        System.out.println(localDateTime.getMonth());//JANUARY
        System.out.println(localDateTime.getMonthValue());//1
        System.out.println(localDateTime.getMinute());//36

        //体现不可变性
        //withXxx()：设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2021-01-18
        System.out.println(localDate1);//2021-01-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);//2021-01-18T15:44:48.873
        System.out.println(localDateTime2);//2021-01-18T04:44:48.873

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

    }
    /*
    Instance的使用
    类似于java.util.Date类
     */
     @Test
    public void test2()
     {
         //now():获取本初子午线对应的标准时间
         Instant instant = Instant.now();
         System.out.println(instant);//2021-01-18T08:22:26.487Z

         //添加时间的偏移量
         OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
         System.out.println(offsetDateTime);//2021-01-18T16:26:42.955+08:00

         //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数--->Date类的getTime()
         long milli = instant.toEpochMilli();
         System.out.println(milli);//1610958593825

         //ofEpochMilli：通过给定的毫秒数，获取Instance实例--->Date(Long millis)
         Instant instant1 = Instant.ofEpochMilli(1610958593825L);
         System.out.println(instant1);//2021-01-18T08:29:53.825Z
     }

    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
     */
     @Test
    public void test3()
    {
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期--->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2021-01-18T16:51:14.565
        System.out.println(str1);//2021-01-18T16:51:14.565
        //解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2021-01-18T16:51:14.565");
        System.out.println(parse);//{},ISO resolved to 2021-01-18T16:51:14.565

        //方式二：
        //本地化相关的格式。如：ofLocalizedDateTime()
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化：日期--->字符串
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//21-1-18 下午5:02
        //解析：字符串--->日期
        TemporalAccessor parse1 = formatter1.parse("21-1-18 下午5:02");
        System.out.println(parse1);//{},ISO resolved to 2021-01-18T17:02

        //本地化相关的格式。如：ofLocalizedDate()
        //FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化：日期--->字符串
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2021年1月18日 星期一
        //解析：字符串--->日期
        TemporalAccessor parse2 = formatter2.parse("2021年1月18日 星期一");
        System.out.println(parse2);//{},ISO resolved to 2021-01-18

        //方式三：自定义的格式。如：ofPattern("yyyy-MM--dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
       //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2021-01-18 06:06:33
        //解析
        TemporalAccessor parse3 = formatter3.parse("2021-01-18 06:06:33");
        System.out.println(parse3);
        //{SecondOfMinute=33, MicroOfSecond=0, HourOfAmPm=6, NanoOfSecond=0, MinuteOfHour=6, MilliOfSecond=0},ISO resolved to 2021-01-18
    }

    @Test
    public void test4()
    {
        //ZoneId：类中包含了所有的时区信息
        //ZoneId的getAvailableZoneIds()：获取所有的ZoneId(时区)
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for(String s : zoneIds)
        {
            System.out.println(s);
        }

        //ZoneId的of()：获取指定时区的时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime);//2021-01-18T19:27:25.667

        //ZoneDateTime：带时区的日期时间
        //ZonedDateTime的now()：获取本时区的ZonedDateTime的对象
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);//2021-01-18T18:27:25.987+08:00[Asia/Shanghai]

        //ZonedDateTime的now(ZoneId id)：获取指定时区的ZonedDateTime的对象
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime1);//2021-01-18T19:27:25.988+09:00[Asia/Tokyo]
    }

    @Test
    public void test5()
    {
        //Duration：用于计算两个“时间”间隔，以秒和纳秒为基准
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15,23,32);
        //between()：静态方法，返回Duration对象，表示两个时间的间隔
        Duration duration = Duration.between(localTime1, localTime);
        System.out.println(duration);//PT3H15M42.737S
        System.out.println(duration.getSeconds());//11742
        System.out.println(duration.getNano());//737000000

        LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
        Duration duration1 = Duration.between(localDateTime1, localDateTime);
        System.out.println(duration1.toDays());//-365
    }

    @Test
    public void test6()
    {
        //Period:用于计算两个“日期”间隔，以年、月、日衡量
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2028,3,19);

        Period period = Period.between(localDate,localDate1);
        System.out.println(period);//P7Y2M1D
        System.out.println(period.getYears());//7
        System.out.println(period.getMonths());//2
        System.out.println(period.getDays());//1

        Period period1 = period.withYears(2);
        System.out.println(period1);//P2Y2M1D
    }

    @Test
    //今日日期：2021.1.18
    public void test7()
    {
        //
        //获取当前日期的下一个周日是哪天？
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
        System.out.println(localDateTime);//2021-01-24T19:03:59.289
        //获取下一个工作日是哪天？
        LocalDate localDate = LocalDate.now().with(new TemporalAdjuster()
        {
            @Override
            public Temporal adjustInto(Temporal temporal)
            {
                LocalDate date = (LocalDate)temporal;
                if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                {
                    return date.plusDays(3);
                }
                else if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                {
                    return date.plusDays(2);
                }
                else
                {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + localDate);//下一个工作日是：2021-01-19
    }


}
