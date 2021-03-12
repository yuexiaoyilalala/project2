package com.kelly.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 20:03
 */
class Window implements Runnable
{
    private int ticket = 100;
    //1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                //2. 调用锁定方法lock()方法
                lock.lock();
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
                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                }
                else
                {
                    break;
                }
            }
            finally
            {
                //3.调用解锁方法lock()
                lock.unlock();
            }
        }
    }
}
public class LockTest
{
    public static void main(String[] args)
    {
        Window w = new Window();

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

