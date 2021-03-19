package com.kelly.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/15 15:32
 */
public class LambdaTest2
{
    @Test
    public void test1()
    {
        happyTime(500, new Consumer<Double>()
        {
            @Override
            public void accept(Double aDouble)
            {
                System.out.println("价格为：" + aDouble);//价格为：500.0
            }
        });

        System.out.println("******************");

        happyTime(400,aDouble ->System.out.println("喝了一口水价格为：" + aDouble));//喝了一口水价格为：400.0
    }

    public void happyTime(double money , Consumer<Double> con)
    {
        con.accept(money);
    }

    @Test
    public void test2()
    {
        List<String> list = Arrays.asList("北京","南京","天津","东京");
        List<String> filterStrs = filterString(list, new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);//[北京, 南京, 东京]

        System.out.println("******************");

        List<String> filterStrs1 = filterString(list,s -> s.contains("京"));

        System.out.println(filterStrs1);//[北京, 南京, 东京]
    }

    //根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre)
    {
        ArrayList<String>  filterList = new ArrayList<>();
        for(String s : list)
        {
            if(pre.test(s))
            {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
