package com.kelly.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/18 22:54
 */
public class CompareTest
{
    /*
    Comparable接口的使用举例：自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式
    2.像String、包装类重写compareTo(obj)方法以后，进行了从小到大的排列
    3.重写compareTo(obj)的规则：
      如果当前对象this大于形参对象obj，则返回正整数
      如果当前对象this小于形参对象obj，则返回负整数
      如果当前对象this等于形参对象obj，则返回零

    4.对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写了compareTo(obj)方法，在
    compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1()
    {
          String[] arr = new String[]{"AA","KK","SS","EE","GG","DD"};
          Arrays.sort(arr);
          System.out.println(Arrays.toString(arr));//[AA, DD, EE, GG, KK, SS]
    }

    @Test
    public void test2()
    {
          Goods[] arr = new Goods[5];
          arr[0] = new Goods("lenovoMouse",34);
          arr[1] = new Goods("dellMouse",43);
          arr[2] = new Goods("xiaomiMouse",12);
          arr[3] = new Goods("appleMouse",98);
          arr[4] = new Goods("honorMouse",43);
          Arrays.sort(arr);//根据元素的自然顺序对指定对象数组按升序进行排序。
          
          System.out.println(Arrays.toString(arr));
        //[Goods{name='xiaomiMouse', price=12.0},
        // Goods{name='lenovoMouse', price=34.0},
        // Goods{name='honorMouse', price=43.0},
        // Goods{name='dellMouse', price=43.0},
        // Goods{name='appleMouse', price=98.0}]

    }

    /*
    Comparator接口的使用：定制排序
    1. 背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    那么可以考虑使用Comparable的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
      如果方法返回正整数，则表示o1大于o2;
      如果方法返回负整数，则表示o1小于o2;
      如果方法返回零，则表示o1等于o2。
     */
    @Test
    public void test3()
    {
        String[] arr = new String[]{"AA","KK","SS","EE","GG","DD"};
        Arrays.sort(arr, new Comparator()
          {
              //按照字符串从大到小的顺序排列
              @Override
              public int compare(Object o1, Object o2)
              {
                  if(o1 instanceof String && o2 instanceof String)
                  {
                      String s1 = (String) o1;
                      String s2 = (String) o2;
                      return -s1.compareTo(s2);
                  }
                  //return 0;
                  throw new RuntimeException("传入的数据类型不一致！");
              }
          });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4()
    {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("appleMouse",98);
        arr[4] = new Goods("honorMouse",63);
        arr[5] = new Goods("honorMouse",43);
        Arrays.sort(arr, new Comparator()
        {
            //指明商品比较大小的方式：按照产品名称从低到高排序,再按照价格从低到高排序
            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof Goods && o2 instanceof Goods)
                {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(g2.getName()))
                    {
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }
                    else
                    {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致！");
                //return 0;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}



