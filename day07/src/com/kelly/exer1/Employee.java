package com.kelly.exer1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/3 19:19
 */
public class Employee implements Comparable
{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee()
    {

    }

    public Employee(String name, int age, MyDate birthday)
    {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(MyDate birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + '}';
    }

    //按name排
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Employee)
        {
            Employee e = (Employee)o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("传入的类型不一致！");

    }
}


