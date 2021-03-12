package com.kelly.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/16 23:31
 */
public class DateTimeTest
{
    //1. System类中的currentTimeMillis()
    @Test
    public void test1()
    {
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /*
    java.util.Date类
              |---java.sql.Date类
    1. 两个构造器的使用
       >构造器一：Date():创建一个对应当前时间的Date对象
       >构造器二：创建指定毫秒数的Date对象
    2. 两个方法的使用
       >toString():显示当前的年、月、日、时、分、秒
       >getTine():获取当前Date对象对应的毫秒数（时间戳）
    3. java.sql.Date对应着数据库中日期类型的变量
       >如何实例化
       >如何将java.uti.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2()
    {
        //构造器一：Date():创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Jan 16 23:43:34 CST 2021
        System.out.println(date1.getTime());//1610811910740

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1610811910740L);
        System.out.println(date2.toString());//Sat Jan 16 23:43:34 CST 2021

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(647984568587L);
        System.out.println(date3);//1990-07-15

        //如何将java.uti.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(35534363535345L);
//        java.sql.Date date5 = (java.sql.Date)date4;

        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }








}
