package com.kelly.java;

import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/15 15:36
 */
public class StringMethodTest
{
    @Test
    public void test1()
    {
        String s1 = "HelloWorld";
        System.out.println(s1.length());//10

        s1.charAt(0);//h
        s1.charAt(9);//d

        System.out.println(s1.isEmpty());//false

        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变，仍然为原来的字符串
        System.out.println(s2);//修改成小写以后的字符串

        String s3 = "  he llo  world";
        String s4 = s3.trim();
        System.out.println("------" + s3 + "------");//------  he llo  world------
        System.out.println("------" + s4 + "------");//------he llo  world------

        String s5 = "HelloWorld";
        String s6 = "helloworld";
        System.out.println(s5.equals(s6));//false
        System.out.println(s5.equalsIgnoreCase(s6));//true

        String s7 = "abc";
        String s8 = s7.concat("def");
        System.out.println(s8);//abcdef

        String s9 = "abc";
        String s10 = new String("abd");
        System.out.println(s9.compareTo(s10));//-1 涉及到字符串排序

        String s11 = "北京尚硅谷教育";
        String s12 = s11.substring(2);
        System.out.println(s11);//北京尚硅谷教育
        System.out.println(s12);//尚硅谷教育
        String s13 = s11.substring(2, 5);
        System.out.println(s13);//尚硅谷
    }

    @Test
    public void test2()
    {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);//true
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);//false
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);//true

        String str2 = "wo";
        System.out.println(str1.contains(str2));//true
        System.out.println(str1.indexOf("lo"));//3
        System.out.println(str1.indexOf("lo",5));//-1
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));//7
        System.out.println(str3.lastIndexOf("or",6));//4
    }

    @Test
    public void test3()
    {
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace("北", "东");
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成逗号,如果结果中开头和结尾有逗号的话去掉
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);

        str = "12345";
        //判断str字符串中是否全部由数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++)
        {
            System.out.println(strs[i]);
        }
        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++)
        {
            System.out.println(strs2[i]);
        }
    }
}




