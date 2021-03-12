package com.kelly.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/31 13:06
 */
public class CollectionTest
{
    @Test
    public void test1()
    {
        Collection coll = new ArrayList();

        //1.add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //2.size():获取添加元素的个数
        System.out.println(coll.size());//4

        //3.addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6

        //4.clear():清空集合元素
        coll.clear();

        //5.isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }
}

