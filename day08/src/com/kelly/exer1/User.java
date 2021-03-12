package com.kelly.exer1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/10 14:23
 */
public class User
{
    private int id;
    private int age;
    private String name;

    public User()
    {
    }

    public User(int id, int age, String name)
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
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

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof User))
        {
            return false;
        }

        User user = (User) o;

        if (id != user.id)
        {
            return false;
        }
        if (age != user.age)
        {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }
}

