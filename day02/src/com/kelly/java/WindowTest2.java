package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 16:09
 */
//ʹ��ͬ���������ʵ��Runnable�ӿڵķ�ʽ���̰߳�ȫ����
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
    private synchronized void show()//ͬ����������this
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
                System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ�� " + ticket);
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

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }
}


