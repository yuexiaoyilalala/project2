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
        //��ʽһ��Ч���Բ�
//        synchronized (Bank.class)
//        {
//            if(instance == null)
//            {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //��ʽ����Ч�ʸ���
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

