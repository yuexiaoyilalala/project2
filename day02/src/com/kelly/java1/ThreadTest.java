package com.kelly.java1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 17:40
 */
public class ThreadTest
{
    public static void main(String[] args)
    {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread()
        {
            @Override
            public void run()
            {
                synchronized (s1)
                {
                    s1.append("a");
                    s2.append("1");
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    synchronized (s2)
                    {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                synchronized (s2)
                {
                    s1.append("c");
                    s2.append("3");
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    synchronized (s1)
                    {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}

