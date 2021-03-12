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
    //生产产品
    public synchronized void productProduct()
    {
        if(productCount < 20)
        {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "个产品");
            notify();
        }
        else{
            //等待
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

    //消费产品
    public synchronized void consumeProduct()
    {
        if(productCount > 0)
        {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        }
        else{
            //等待
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
class Producer extends Thread//生产者
{
    private Clerk clerk;

    public Producer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"：开始生产产品...");
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

class Cusumer extends Thread//消费者
{
    private Clerk clerk;

    public Cusumer(Clerk clerk)
    {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"：开始消费产品...");
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
        p1.setName("生产者");
        Cusumer c1 = new Cusumer(clerk);
        c1.setName("消费者1");
        Cusumer c2 = new Cusumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
