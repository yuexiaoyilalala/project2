package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 16:09
 */
//使用同步方法解决实现Runnable接口的方式的线程安全问题
class Window2 implements Runnable
{
    private int ticket = 20;
    Object obj = new Object();

    @Override
    public void run()
    {
        while (true)
        {
            show();
        }
    }
    private synchronized void show()//同步监视器：this
    {
        //synchronized(this)
        //{
            if (ticket > 0)
            {
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                ticket--;
            }
        //}
    }
}

public class WindowTest2
{
    public static void main(String[] args)
    {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}


