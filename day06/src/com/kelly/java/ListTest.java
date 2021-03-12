package com.kelly.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/1 10:59
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *       |---List接口：存储有序的、可重复的数据。--->"动态"数组，替换原有的数组
 *             |---ArrayList
 *             |---LinkedList
 *             |---Vector
 */
public class ListTest
{
    @Test
    public void test1()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);//[123, 456, AA, Person{name='Tom', age=12}, 456]

        //void add(int index , Object ele)：在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);//[123, BB, 456, AA, Person{name='Tom', age=12}, 456]

        //boolean addAll(int index , Collection eles)：从index位置开始将eles中的所有元素添加进来
        //boolean addAll(Collection eles)：将eles中的所有元素添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        //list.add(list1);
        System.out.println(list.size());//9
        //System.out.println(list.size());//7

        //Object get(int index)：获取指定index位置的元素
        System.out.println(list.get(0));//123
    }

    @Test
    public void test2()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        //int indexOf(Object obj)：返回obj在集合中首次出现的位置，如果不存在则返回-1
        int index = list.indexOf(456);
        System.out.println(index);//1

        //int lastIndexOf(Object obj)：返回obj在当前集合中末次出现的位置，如果不存在则返回-1
        System.out.println(list.lastIndexOf(456));//4

        //Object remove(int index)：移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);//123
        System.out.println(list);//[456, AA, Person{name='Tom', age=12}, 456]

        //Object set(int index , Object ele)：设置指定index位置的元素ele
        list.set(1,"CC");
        System.out.println(list);//[456, CC, Person{name='Tom', age=12}, 456]

        //List subList(int fromIndex , int toIndex)：返回从fromIndex到toIndex左闭右开位置的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);//[Person{name='Tom', age=12}, 456]
        System.out.println(list);//[456, CC, Person{name='Tom', age=12}, 456]
    }

    @Test
    public void test3()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //方式二：增强for循环
        for(Object obj : list)
        {
            System.out.println(obj);
        }

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}

