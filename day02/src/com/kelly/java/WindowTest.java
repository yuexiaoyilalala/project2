package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 18:56
 */
//使用同步代码块解决继承Thread类的方式的线程安全问题
//说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑当前类充当同步监视器
public class WindowTest
{
    public static void main(String[] args)
    {
        Windows t1 = new Windows();
        Windows t2 = new Windows();
        Windows t3 = new Windows();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows extends Thread
{
    private static int ticket = 100;

    private static Object obj = new Object();
    @Override
    public void run()
    {
        while (true)
        {
            //错误的
            //synchronized(this)：此时的this代表t1,t2,t3三个对象
            //正确的
            //synchronized(Windows.class)
            //Class clazz = Windows.class,Windows.class只会加载一次
            //正确的
            synchronized(obj)
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
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
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

