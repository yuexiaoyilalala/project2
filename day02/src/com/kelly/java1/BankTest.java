package com.kelly.java1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 17:15
 */
public class BankTest
{
    public static void main(String[] args)
    {

    }
}

class Bank
{
    private static Bank instance = null;

    private Bank()
    {

    }

    public static Bank getInstance()
    {
        //方式一：效率稍差
//        synchronized (Bank.class)
//        {
//            if(instance == null)
//            {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null)
        {
            synchronized (Bank.class)
            {
                if (instance == null)
                {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

