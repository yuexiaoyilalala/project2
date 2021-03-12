package com.kelly.java;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/17 23:45
 */
public class DateTimeTest
{
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作
    1.1 格式化：日期--->字符串
    1.2 解析：格式化的逆过程，字符串--->日期

    2.SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException
    {
        //实例化SimpleDateFormat：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);//日期：Mon Jan 18 12:48:33 CST 2021
        String format = sdf.format(date);
        System.out.println(format);//字符串：21-1-18 下午12:48

        //解析：格式化的逆过程，字符串--->日期
        String str = "21-1-17 下午11:53";//字符串
        Date date1 = sdf.parse(str);
        System.out.println(date1);//日期：Sun Jan 17 23:53:00 CST 2021

        //实例化SimpleDateFormat：使用带参的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //按照指定的方式格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//字符串：2021-01-18 12:04:03
        //按照指定的方式解析
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则会抛异常
        Date date2 = sdf1.parse("2021-01-18 12:04:03");
        System.out.println(date2);//日期：Mon Jan 18 00:04:03 CST 2021
    }

    /*
    练习一：字符串“2020-09-08”转换java.sql.Date
     */
    @Test
    public void testExer() throws ParseException
    {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        //System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);//2020-09-08
    }

    @Test
    public void test1() throws ParseException
    {
         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
         Date date1 = sdf1.parse("1990-01-01");
         //System.out.println(date1);
         System.out.println(date1.getTime());

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = sdf2.parse("2020-09-08");
        //System.out.println(date1);
        System.out.println(date2.getTime());

        long i = (date2.getTime() - date1.getTime())/(1000 * 60 * 60 * 24);
        System.out.println(i);
        int j = (int)i;
    }

    /*
    Calendar日历（抽象类）的使用
     */
    @Test
    public void testCalendar()
    {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,19);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()：日历类--->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()：Date--->日历类
         Date date1 = new Date();
         calendar.setTime(date1);
         days = calendar.get(Calendar.DAY_OF_MONTH);
         System.out.println(days);
    }
}

