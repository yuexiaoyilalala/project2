package com.kelly.java2;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/14 13:48
 */
class Clerk
{
    private int productCount = 0;
    //������Ʒ
    public synchronized void productProduct()
    {
        if(productCount < 20)
        {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "����ʼ������" + productCount + "����Ʒ");
            notify();
        }
        else{
            //�ȴ�
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    //���Ѳ�Ʒ
    public synchronized void consumeProduct()
    {
        if(productCount > 0)
        {
            System.out.println(Thread.currentThread().getName() + "����ʼ���ѵ�" + productCount + "����Ʒ");
            productCount--;
            notify();
        }
        else{
            //�ȴ�
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread//������
{
    private Clerk clerk;

    public Producer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"����ʼ������Ʒ...");
        while (true)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            clerk.productProduct();
        }
    }
}

class Cusumer extends Thread//������
{
    private Clerk clerk;

    public Cusumer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"����ʼ���Ѳ�Ʒ...");
        while (true)
        {
            try
            {
                Thread.sleep(20);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class ProductTest
{
    public static void main(String[] args)
    {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("������");
        Cusumer c1 = new Cusumer(clerk);
        c1.setName("������1");
        Cusumer c2 = new Cusumer(clerk);
        c2.setName("������2");

        p1.start();
        c1.start();
        c2.start();
    }
}
