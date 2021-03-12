package com.kelly.java;

import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/17 23:25
 */
public class IDEADebug
{
    @Test
    public void testStringBuffer()
    {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//NullPointerException
        System.out.println(sb1);
    }

}
