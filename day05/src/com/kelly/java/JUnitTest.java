package com.kelly.java;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/21 20:44
 */
public class JUnitTest
{
    private static Object[] array;
    private static int total;

    @BeforeClass
    public static void init()
    {
        System.out.println("初始化数组");
        array = new Object[5];
    }

    @Before
    public void before()
    {
        System.out.println("调用之前total=" + total);
    }

    @Test
    public void add()
    {
        //往数组中存储一个元素
        System.out.println("add");
        array[total++] = "hello";
    }

    @After
    public void after()
    {
        System.out.println("调用之前total=" + total);
    }

    @AfterClass
    public static void destory()
    {
        array = null;
        System.out.println("销毁数组");
    }
}

