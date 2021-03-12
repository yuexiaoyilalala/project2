package com.kelly.java2;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 22:18
 */
class Number implements Runnable
{
    private int number = 1;
    @Override
    public void run()
    {
         while (true)
         {
             synchronized (this)
             {
                 this.notify();
                 if(number <= 100)
                 {
                     try
                     {
                         Thread.sleep(10);
                     }
                     catch (InterruptedException e)
                     {
                         e.printStackTrace();
                     }
                     System.out.println(Thread.currentThread().getName() + ":" + number);
                     number++;
                     try
                     {
                         //使得调用如下wait()方法的线程进入阻塞状态
                         this.wait();
                     }
                     catch (InterruptedException e)
                     {
                         e.printStackTrace();
                     }
                 }
                 else
                 {
                     break;
                 }
             }
         }
    }
}
public class CommunicationTest
{
    public static void main(String[] args)
    {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}

