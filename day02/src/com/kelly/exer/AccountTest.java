package com.kelly.exer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 21:13
 */
class Account
{
   private double balance;

    public Account(double balance)
    {
        this.balance = balance;
    }

    //´æÇ®
    public synchronized void deposit(double amt)
    {
        if(amt > 0)
        {
            balance += amt;
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "´æÇ®³É¹¦£¡Óà¶îÎª£º" + balance);
        }
    }
}

class Customer extends Thread
{
     private Account acct;

    public Customer(Account acct)
    {
        this.acct = acct;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            acct.deposit(1000);
        }
    }
}

public class AccountTest
{
    public static void main(String[] args)
    {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("¼×");
        c2.setName("ÒÒ");

        c1.start();
        c2.start();
    }
}

