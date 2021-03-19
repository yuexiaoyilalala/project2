package com.kelly.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/15 13:53
 */
public class LambdaTest1
{
    //语法格式一：无参，无返回值
    @Test
    public void test1()
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("我爱北京！");
            }
        };

        r1.run();//我爱北京！

        System.out.println("****************************");

        Runnable r2 = () -> {System.out.println("我爱故宫！");};

        r2.run();//我爱故宫！
    }

    //语法格式二：Lambda需要一个参数，但是没有返回值
    @Test
    public void test2()
    {
        Consumer<String> con = new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        };

        con.accept("To be or not to be,this is a question");//To be or not to be,this is a question

        System.out.println("****************************");

        Consumer<String> con1 = (String s) -> {System.out.println(s);};

        con1.accept("?");//?
    }

    //语法格式三：数据类型可以省略，因为可有编译器推断得出，称为“类型推断”
    @Test
    public void test3()
    {
        Consumer<String> con1 = (String s) -> {System.out.println(s);};

        con1.accept("?");//?

        System.out.println("****************************");

        Consumer<String> con2 = (s) -> {System.out.println(s);};

        con2.accept("?");//?

    }

    //类型推断
    @Test
    public void test4()
    {
        //ArrayList<String> list = new ArrayList<String>()
        ArrayList<String> list = new ArrayList<>();

        //int[] arr = {1,2,3};
        int[] arr = new int[]{1,2,3};
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test5()
    {
        Consumer<String> con1 = (s) -> {System.out.println(s);};

        con1.accept("?");//?

        System.out.println("****************************");

        Consumer<String> con2 = s -> {System.out.println(s);};

        con2.accept("?");//?
    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6()
    {
        Comparator<Integer> com1 = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12,21));
        /*
        12
        21
        -1
         */

        System.out.println("****************************");

        Comparator<Integer> com2 = (o1,o2) ->
        {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12,6));
        /*
        12
        6
        1
         */
    }

    //语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7()
    {
        Comparator<Integer> com1 = (o1,o2) ->
        {
            return o1.compareTo(o2);
        };

        System.out.println(com1.compare(12,6));//1

        System.out.println("****************************");

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(12,21));//-1
    }

    @Test
    public void test8()
    {
        Consumer<String> con1 = s -> {System.out.println(s);};

        con1.accept("?");//?

        System.out.println("****************************");

        Consumer<String> con2 = s -> System.out.println(s);

        con2.accept("?");//?
    }
}
