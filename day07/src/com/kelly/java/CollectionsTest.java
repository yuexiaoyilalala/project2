package com.kelly.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/6 11:25
 */
public class CollectionsTest
{
    @Test
    public void test1()
    {
        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);//[123, 43, 765, -97, 0]

        Collections.reverse(list);
        System.out.println(list);//[0, -97, 765, 43, 123]

        Collections.shuffle(list);
        System.out.println(list);//[0, 43, 765, -97, 123]

        Collections.sort(list);
        System.out.println(list);//[-97, 0, 43, 123, 765]

        Collections.swap(list,1,2);
        System.out.println(list);//[-97, 43, 0, 123, 765]

        int frequency = Collections.frequency(list, 765);
        System.out.println(frequency);//1
    }

    @Test
    public void test2()
    {
        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//
//        Collections.copy(dest,list);

        //正确的
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//5
        Collections.copy(dest,list);
        System.out.println(dest);//[123, 43, 765, -97, 0]
    }

    @Test
    public void test3()
    {
        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //返回的list1即为线程安全的
        List list1 = Collections.synchronizedList(list);
    }
}


