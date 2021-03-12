package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 16:31
 */
//使用同步方法解决继承Thread类的方式的线程安全问题
public class WindowTest3
{
    public static void main(String[] args)
    {
        Windows2 t1 = new Windows2();
        Windows2 t2 = new Windows2();
        Windows2 t3 = new Windows2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows2 extends Thread
{
    private static int ticket = 20;

    @Override
    public void run()
    {
        while (true)
        {
            show();

        }
    }

    private static synchronized void show()//同步监视器：Windows2.class
    //private synchronized void show()//同步监视器：t1,t2,t3。此种解决方式是错误的。
    {
        if(ticket > 0)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //方法是静态的，可以用对象调
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

