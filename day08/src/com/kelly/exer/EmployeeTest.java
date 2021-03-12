package com.kelly.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/3 19:31
 */
public class EmployeeTest
{
    //问题一：使用自然排序
    @Test
    public void test1()
    {
        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    //问题二：定制排序
    @Test
    public void test2()
    {
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>()
        {
            //使用泛型以后的写法
            @Override
            public int compare(Employee o1, Employee o2)
            {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();

                //比较日
                return b1.compareTo(b2);
            }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,12,4));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
