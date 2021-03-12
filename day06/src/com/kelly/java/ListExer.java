package com.kelly.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/1 15:40
 */
public class ListExer
{
    /*
    区分List中remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove()
    {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    public static void updateList(List list)
    {
        //list.remove(2);//[1,2]
        list.remove(new Integer(2));//[1,3]
    }
}
