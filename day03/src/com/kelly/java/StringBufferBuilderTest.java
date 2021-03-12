package com.kelly.java;

import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/16 18:41
 */
public class StringBufferBuilderTest
{
    @Test
    public void test1()
    {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }

    @Test
    public void test2()
    {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        //s1.delete(2,4);//ab1
        //s1.replace(2,4,"hello");//abhello1
        //s1.insert(2,false);//abfalsec11
        //s1.reverse();//11abc
        String s2 = s1.substring(1,3);
        System.out.println(s1);
        System.out.println(s2);//bc
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);//mbc
    }

    @Test
    public void test3()
    {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
           text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String:" + (endTime - startTime));
    }
}
