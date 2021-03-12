package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 22:31
 */
//使用同步代码块解决实现Runnable接口的方式的线程安全问题
class Window1 implements Runnable
{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run()
    {
        while (true)
        {
            //方式二：
            //synchronized(obj)
            //此时的this：唯一的Window1的对象
            //方式一：
            synchronized(this)
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
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为： " + ticket);
                    ticket--;
                }
                else
                {
                    break;
                }
            }
        }
    }
}

public class WindowTest1
{
    public static void main(String[] args)
    {
        Window1 w = new Window1();

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

