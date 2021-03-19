package com.kelly.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/15 21:20
 */
public class ConstructorRefTest
{
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1()
    {
        Supplier<Employee> sup = new Supplier<Employee>()
        {
            @Override
            public Employee get()
            {
                return new Employee();
            }
        };
        System.out.println(sup.get());//Employee{id=0, name='null', age=0, salary=0.0}

        System.out.println("*************************");

        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());//Employee{id=0, name='null', age=0, salary=0.0}

        System.out.println("*************************");

        Supplier<Employee> sup2 = Employee :: new;
        System.out.println(sup2.get());//Employee{id=0, name='null', age=0, salary=0.0}
    }

    //Function中的R apply(T t)
    @Test
    public void test2()
    {
        Function<Integer,Employee> func = new Function<Integer, Employee>()
        {
            @Override
            public Employee apply(Integer id)
            {
                return new Employee(id);
            }
        };

        Employee employee1 = func.apply(1001);

        System.out.println(employee1);//Employee{id=1001, name='null', age=0, salary=0.0}

        System.out.println("*************************");

        Function<Integer,Employee> func1 = id -> new Employee(id);

        Employee employee = func1.apply(1001);

        System.out.println(employee);//Employee{id=1001, name='null', age=0, salary=0.0}

        System.out.println("*************************");

        Function<Integer,Employee> func2 = Employee :: new;

        Employee employee2 = func2.apply(1001);

        System.out.println(employee2);//Employee{id=1001, name='null', age=0, salary=0.0}
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3()
    {
        BiFunction<Integer,String,Employee> func = new BiFunction<Integer, String, Employee>()
        {
            @Override
            public Employee apply(Integer id, String name)
            {
                return new Employee(id,name);
            }
        };

        Employee employee = func.apply(1001,"Tom");

        System.out.println(employee);//Employee{id=1001, name='Tom', age=0, salary=0.0}

        System.out.println("*************************");

        BiFunction<Integer,String,Employee> func1 = (id,name) -> new Employee(id,name);

        Employee employee1 = func1.apply(1001,"Tom");

        System.out.println(employee1);//Employee{id=1001, name='Tom', age=0, salary=0.0}

        System.out.println("*************************");

        BiFunction<Integer,String,Employee> func2 = Employee::new;

        Employee employee2 = func2.apply(1001,"Tom");

        System.out.println(employee2);//Employee{id=1001, name='Tom', age=0, salary=0.0}
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4()
    {
        Function<Integer, String[]> func = new Function<Integer, String[]>()
        {
            @Override
            public String[] apply(Integer length)
            {
                return new String[length];
            }
        };

        String[] arr = func.apply(5);

        System.out.println(Arrays.toString(arr));//[null, null, null, null, null]

        System.out.println("*************************");

        Function<Integer, String[]> func1 = length -> new String[length];

        String[] arr1 = func1.apply(5);

        System.out.println(Arrays.toString(arr1));//[null, null, null, null, null]

        System.out.println("*************************");

        Function<Integer, String[]> func2 = String[] :: new;

        String[] arr2 = func1.apply(10);

        System.out.println(Arrays.toString(arr2));//[null, null, null, null, null, null, null, null, null, null]
    }
}
