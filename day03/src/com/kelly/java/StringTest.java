package com.kelly.java;
import org.junit.Test;
/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/14 22:10
 */
public class StringTest
{
    @Test
    public void test1()
    {
        String s1 = "abc";//字面量的定义方法
        String s2 = "abc";
        //s1 = "hello";

        //比较s1和s2的地址值
        System.out.println(s1 == s2);//true
        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("***************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        System.out.println("***************");

        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc

    }

    @Test
    public void test2()
    {
        //通过字面量定义的方式，此时s1和s2的数据javaEE声明在方法区的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new+构造器的方式，此时s3和s4是数据在堆空间开辟空间后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
    }

    @Test
    public void test3()
    {
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true
    }

    @Test
    public void test4()
    {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s5.intern();//返回值得到的s8使用常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true
    }

    @Test
    public void test5()
    {
        String s1 = "javaEEhadoop";
        final String s2 = "javaEE";//s2常量
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//true
    }
}



