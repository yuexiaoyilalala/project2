package com.kelly.java1;

import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/9 12:41
 */
public class DAO<T>//表的共性操作的DAO
{
    //添加一条记录
    public void add(T t)
    {

    }

    //删除一条记录
    public boolean remove(int index)
    {
        return false;
    }

    //修改一条记录
    public void update(int index,T t)
    {

    }

    //查询一条记录
    public T getIndex(int index)
    {
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index)
    {
        return null;
    }

    //泛型方法
    public <E> E getValue()
    {
        return null;
    }
}



