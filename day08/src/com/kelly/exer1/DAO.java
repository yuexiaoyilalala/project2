package com.kelly.exer1;

import java.util.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/10 13:39
 */
public class DAO<T>
{
    private Map<String,T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity)
    {
         map.put(id,entity);
    }

    //从Map中获取id对应的对象
    public T get(String id)
    {
         return map.get(id);
    }

    //替换Map中key为id的内容，改为entity对象
    public void update(String id,T entity)
    {
         if(map.containsKey(id))
         {
             map.put(id,entity);
         }
    }

    //返回Map中存放所谓所有T对象
    public List<T> list()
    {
        ArrayList<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for(T t : values)
        {
            list.add(t);
        }
        return list;
    }

    //删除指定id对象
    public void delete(String id)
    {
       map.remove(id);
    }
}
