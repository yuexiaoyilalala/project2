package com.kelly.java1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 18:34
 */
class A
{
    public synchronized void foo(B b)//ͬ����������a
    {
        System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + "������Aʵ����foo����");
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + "��ͼ����Bʵ����last����");
        b.last();
    }
    public synchronized void last()//ͬ����������a
    {
        System.out.println("����A���last�����ڲ�");
    }
}

class B
{
    public synchronized void bar(A a)//ͬ����������b
    {
        System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + "������Bʵ����bar����");
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + "��ͼ����Aʵ����last����");
        a.last();
    }

    public synchronized void last()//ͬ����������b
    {
        System.out.println("����B���last�����ڲ�");
    }
}
public class DeadLock implements Runnable
{
    A a = new A();
    B b = new B();

    public void init()
    {
        Thread.currentThread().setName("���߳�");
        //����a�����foo����
        a.foo(b);
        System.out.println("�������߳�֮��");
    }
    @Override
    public void run()
    {
        Thread.currentThread().setName("���߳�");
        //����b�����bar����
        b.bar(a);
        System.out.println("���븱�߳�֮��");
    }

    public static void main(String[] args)
    {
        DeadLock d1 = new DeadLock();
        new Thread(d1).start();

        d1.init();
    }
}
