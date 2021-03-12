package com.kelly.java1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Objects;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/1 16:30
 */
public class User implements Comparable
{
    private String name;
    private int age;

    public User()
    {
    }

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        System.out.println("User's equals...");
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof User))
        {
            return false;
        }

        User user = (User) o;

        if (age != user.age)
        {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从大到小排列，年龄从小到大排列
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof User)
        {
            User user = (User)o;
            //return this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0)
            {
                return compare;
            }
            else
            {
                return Integer.compare(this.age,user.age);
            }
        }
        else
        {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}

