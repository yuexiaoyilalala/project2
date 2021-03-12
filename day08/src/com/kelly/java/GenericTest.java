package com.kelly.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/8 14:04
 */
public class GenericTest
{
    //在集合中使用泛型之前的情况：
    @Test
    public void test1()
    {
        ArrayList list = new ArrayList();
        //需求
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
        list.add("Tom");

        for(Object score : list)
        {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer)score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2()
    {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);

        //编译时，就会进行类型检查，保证数据的安全
        //list.add("Tom");

//         for (Integer score : list)
//         {
//             //避免了强转操作
//             int stuScore = score;
//             System.out.println(stuScore);
//         }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
        {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3()
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        //jdk7新特性：类型推断
        //Map<String, Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---" + value);
        }
    }
}


