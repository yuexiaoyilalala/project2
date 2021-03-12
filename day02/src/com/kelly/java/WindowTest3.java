package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 16:31
 */
//ʹ��ͬ����������̳�Thread��ķ�ʽ���̰߳�ȫ����
public class WindowTest3
{
    public static void main(String[] args)
    {
        Windows2 t1 = new Windows2();
        Windows2 t2 = new Windows2();
        Windows2 t3 = new Windows2();

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

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

    private static synchronized void show()//ͬ����������Windows2.class
    //private synchronized void show()//ͬ����������t1,t2,t3�����ֽ����ʽ�Ǵ���ġ�
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
            //�����Ǿ�̬�ģ������ö����
            System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
            ticket--;
        }
    }
}

