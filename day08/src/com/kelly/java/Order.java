package com.kelly.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/8 19:38
 * 自定义泛型类
 */
public class Order<T>
{
     String orderName;
     int orderId;
     //类的内部结构就可以使用类的泛型
     T orderT;

     public Order()
     {
        //编译不通过
//         T[] arr = new T[10];
         //编译通过
         T[] arr = (T[])new Object[10];
     };

    public Order(String orderName, int orderId, T orderT)
    {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public T getOrderT()
    {
        return orderT;
    }

    public void setOrderT(T orderT)
    {
        this.orderT = orderT;
    }

    @Override
    public String toString()
    {
        return "Order{" + "orderName='" + orderName + '\'' + ", orderId=" + orderId + ", orderT=" + orderT + '}';
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderT)
//    {
//        System.out.println(orderT);
//    }

//    public void show()
//    {
          //编译不通过
//        try
//        {
//
//        }
//        catch (T t)
//        {
//
//        }
//    }

    public static <E> List<E> copyFromArrayToList(E[] arr)
    {
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr)
        {
            list.add(e);
        }
        return list;
    }
}
