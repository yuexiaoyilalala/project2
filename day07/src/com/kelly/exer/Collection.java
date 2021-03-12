package com.kelly.exer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/3 21:47
 */
public class Collection
{
    public static List duplicateList(List list)
    {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    public static void main(String args[])
    {
        List list = new ArrayList();
        list.add(new Person(1,"AA"));
        list.add(new Person(2,"CC"));
        list.add(new Person(2,"BB"));
        list.add(new Person(3,"CC"));
        list.add(new Person(3,"CC"));

        List list2 = duplicateList(list);
        for(Object integer : list2)
        {
            System.out.println(integer);
        }
    }
}


