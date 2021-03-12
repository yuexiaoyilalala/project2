package com.kelly.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/1 20:20
 */
public class TreeSetTest
{
    @Test
    public void test1()
    {
        TreeSet set = new TreeSet();
        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
        //向TreeSet中添加的数据，要求是相同类的对象
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2()
    {
        Comparator com = new Comparator()
        {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof User && o2 instanceof User)
                {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return  Integer.compare(u1.getAge(),u2.getAge());
                }
                else
                {
                    throw new RuntimeException("输入的类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Mary",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
