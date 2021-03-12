package com.kelly.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/9 14:59
 */
public class GenericTest
{
    @Test
    public void test1()
    {
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;

        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
        //list1 = list2;
        /*
        反证法：
        假设List1 = List2;
        List1.add(123);导致混入非String的数据，出错

         */
        show(list1);
        show1(list2);
    }

    public void show1(List<String> list)
    {

    }
    public void show(List<Object> list)
    {

    }

    @Test
    public void test2()
    {
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();
    }

    @Test
    public void test3()
    {
        List<Object> list1 = null;
        List<Object> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        //编译通过
        //print(list1);
        //print(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其添加数据
        //list.add("DD");
        //list.add("DD");

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);//AA
        System.out.println(o);

    }

    public void print(List<?> list)
    {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext())
        {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    @Test
    public void test4()
    {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
        //list1 = list5;

        //list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        //编译不通过
        //Person obj = list2.get(0);

        list2.add(new Person());
        list2.add(new Student());
    }

}
