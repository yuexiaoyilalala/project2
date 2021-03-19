package com.kelly.java4;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/19 16:26
 */
public class Girl
{
    private String name;

    public Girl()
    {

    }

    public Girl(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Girl{" + "name='" + name + '\'' + '}';
    }
}
