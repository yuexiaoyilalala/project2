package com.kelly.exer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/3 18:52
 */
public class MyDate implements Comparable<MyDate>
{
    private int year;
    private int month;
    private int day;

    public MyDate()
    {

    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public String toString()
    {
        return "MyDate{" + "year=" + year + ",month=" + month + ",day=" + day + '}';
    }

    //按生日日期的先后顺序
//    @Override
//    public int compareTo(Object o)
//    {
//        if(o instanceof MyDate)
//        {
//            MyDate m = (MyDate)o;
//
//            //比较年
//            int minusYear = this.getYear() - m.getYear();
//            if(minusYear != 0)
//            {
//                return minusYear;
//            }
//
//            //比较月
//            int minusMonth = this.getMonth() - m.getMonth();
//            if(minusMonth != 0)
//            {
//                return minusMonth;
//            }
//
//            //比较日
//            return this.getDay() - m.getDay();
//        }
//        throw new RuntimeException("传入的类型不一致！");
//    }
//}
    public int compareTo(MyDate o)
    {
        //            //比较年
        int minusYear = this.getYear() - o.getYear();
        if (minusYear != 0)
        {
            return minusYear;
        }

//            //比较月
        int minusMonth = this.getMonth() - o.getMonth();
        if (minusMonth != 0)
        {
            return minusMonth;
        }

//            //比较日
        return this.getDay() - o.getDay();
    }
}