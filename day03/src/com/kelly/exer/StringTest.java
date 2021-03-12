package com.kelly.exer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/15 15:07
 */
public class StringTest
{
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[])
    {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args)
    {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}


