package com.kelly.java3;

import com.kelly.java2.Employee;
import com.kelly.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/17 14:32
 */
//测试Stream的实例化
public class StreamAPITest
{
    //创建Stream方式一：通过集合
    @Test
    public void test1()
    {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2()
    {
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static<T>  Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3()
    {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    //创建Stream方式四：创建无限流
    @Test
    public void test4()
    {
        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
//        Function<Integer,Integer> fun1 = new Function<Integer, Integer>()
//        {
//            @Override
//            public Integer apply(Integer integer)
//            {
//                return null;
//            }
//        };

        Stream.iterate(0,t -> t + 2).limit(5).forEach(System.out::println);
        /*
        0
        2
        4
        6
        8
         */

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random ).limit(5).forEach(System.out :: println);
        /*
        0.2809511327719161
        0.2203381739514252
        0.02322008159047495
        0.4684277973208322
        0.8395818747857123
         */
    }
}
