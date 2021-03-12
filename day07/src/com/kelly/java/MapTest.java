package com.kelly.java;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/4 15:53
 */
public class MapTest
{
    @Test
    public void test1()
    {
        Map map = new HashMap();
        //map = new Hashtable();
        map.put(null,123);
    }

    @Test
    public void test2()
    {
        Map map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }

    @Test
    public void test3()
    {
        Map map = new HashMap();
        //Object put(Object key,Object value)：将指定的key-value添加到（或修改）当前map对象中
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);//{AA=87, BB=56, 45=123}

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        //void putAll(Map m)：将m中的所有key-value存放到当前map中
        map.putAll(map1);

        System.out.println(map);//{AA=87, BB=56, CC=123, DD=123, 45=123}

        //Object remove(Object key)：移除指定的key的key-value对，并返回value
        Object value = map.remove("CC");
        System.out.println(value);//123
        System.out.println(map);//{AA=87, BB=56, DD=123, 45=123}

        //void clear()：清空当前map中的所有数据
        map.clear();//与map=null操作不同
        System.out.println(map);//{}
        System.out.println(map.size());//0
    }

    @Test
    public void test4()
    {
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //Object get(Object key):获取指定key对应的value
        System.out.println(map.get(45));//123

        //boolean containsKey(Object key)：是否包含指定的key
        boolean isExit = map.containsKey("BB");
        System.out.println(isExit);//true

        //boolean containsValue(Object value)：是否包含指定的value
        isExit = map.containsValue(123);
        System.out.println(isExit);//true

        //int size():返回map中key-value对的个数


        //boolean isEmpty()：判断当前map是否为空
        map.clear();
        System.out.println(map.isEmpty());//true

        //boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        Map map1 = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        System.out.println(map.equals(map1));//false
    }

    @Test
    public void test5()
    {
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);
        //Set keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());//AA
                                                //BB
                                                //45
        }
        System.out.println();

        //Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        for(Object obj : values)
        {
            System.out.println(obj);//123
                                    //56
                                    //1234
        }
        System.out.println();

        //Set entrySet()：返回所有key-value对构成的Set集合
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext())
        {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());//AA--->123
                                                                           //BB--->56
                                                                           //45--->1234
        }
        System.out.println();

        //方式二：
        //Set keySet()：返回所有key构成的Set集合
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext())
        {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);//AA====123
                                                     //BB====56
                                                     //45====1234
        }
    }
}


