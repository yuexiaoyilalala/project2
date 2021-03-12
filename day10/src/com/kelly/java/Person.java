package com.kelly.java;

import java.io.Serializable;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/4 14:08
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也是可序列化的
 * （默认情况下，基本数据类型可序列化）
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 */
public class Person implements Serializable
{
    public static final long serialVersionUID = 4266656575747L;
    private String name;
    private int age;
    private int id;
    private Account acct;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id, Account acct)
    {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Account getAcct()
    {
        return acct;
    }

    public void setAcct(Account acct)
    {
        this.acct = acct;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", id=" + id + ", acct=" + acct + '}';
    }
}

class Account implements Serializable
{
    public static final long serialVersionUID = 42666545575747L;

    private double balance;

    public Account(double balance)
    {
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "Account{" + "balance=" + balance + '}';
    }
}
