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
    //1. ʵ����ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                //2. ������������lock()����
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
                    System.out.println(Thread.currentThread().getName() + "����Ʊ��Ʊ��Ϊ��" + ticket);
                    ticket--;
                }
                else
                {
                    break;
                }
            }
            finally
            {
                //3.���ý�������lock()
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

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }
}

