package com.kelly.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/15 16:34
 */
public class MethodRefTest
{
    //情况一：对象 :: 非静态方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1()
    {
        Consumer <String> con = new Consumer<String>()
        {
            @Override
            public void accept(String str)
            {
                System.out.println(str);
            }
        };
        con.accept("北京");//北京

        System.out.println("********************");

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");//北京

        System.out.println("********************");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("beijing");//beijing
    }

    @Test
    public void test2()
    {
        Employee emp = new Employee(1001,"Tom",23,5600);

        Supplier<String> sup = new Supplier<String>()
        {
            @Override
            public String get()
            {
                return emp.getName();
            }
        };

        System.out.println(sup.get());//Tom

        System.out.println("********************");
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());//Tom

        System.out.println("********************");
        Supplier<String> sup2 = emp :: getName;
        System.out.println(sup2.get());//Tom
    }

    //情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3()
    {
        Comparator<Integer> com = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer t1, Integer t2)
            {
                return Integer.compare(t1,t2);
            }
        };
        System.out.println(com.compare(12,21));//-1

        System.out.println("********************");

        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(12,21));//-1

        System.out.println("********************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12,3));//1
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4()
    {
        Function<Double,Long> func = new Function<Double, Long>()
        {
            @Override
            public Long apply(Double d)
            {
                return Math.round(d);
            }
        };
        System.out.println(func.apply(12.3));//12

        System.out.println("********************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));//12

        Function<Double,Long> func2 = Math :: round;
        System.out.println(func2.apply(12.3));//13
    }

    //情况三： 类 :: 非静态方法(有难度)
    //Comparator中的int compare(T t1,T t2)
    //String中的int t1.compareTo(t2)
    @Test
    public void test5()
    {
        Comparator<String> com3 = new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                return s1.compareTo(s2);
            }
        };

        System.out.println(com3.compare("abc","abd"));//-1

        System.out.println("********************");

        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc","abd"));//-1

        System.out.println("********************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc","abm"));//-10
    }

    //BiPredicate中的boolean test(T t1 , T t2)
    //String中的boolean t1.equals(t2)
    public void test6()
    {
        BiPredicate<String,String> pre3 = new BiPredicate<String, String>()
        {
            @Override
            public boolean test(String s1, String s2)
            {
                return s1.equals(s2);
            }
        };
        System.out.println(pre3.test("abc","abc"));

        System.out.println("********************");

        BiPredicate<String,String> pre1 = (s1,s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));

        System.out.println("********************");

        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("abc","abc"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName()
    @Test
    public void test7()
    {
        Employee employee = new Employee(1001,"Jerry",23,5500);

        Function<Employee,String> func3 = new Function<Employee, String>()
        {
            @Override
            public String apply(Employee e)
            {
                return e.getName();
            }
        };
        System.out.println(func3.apply(employee));//Jerry
        System.out.println("****************************");

        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));//Jerry

        System.out.println("****************************");

        Function<Employee,String> func2 = Employee :: getName;
        System.out.println(func2.apply(employee));//Jerry

        System.out.println("****************************");
    }
}
