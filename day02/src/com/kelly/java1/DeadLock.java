package com.kelly.java1;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/13 18:34
 */
class A
{
    public synchronized void foo(B b)//同步监视器：a
    {
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了A实例的foo方法");
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用B实例的last方法");
        b.last();
    }
    public synchronized void last()//同步监视器：a
    {
        System.out.println("进入A类的last方法内部");
    }
}

class B
{
    public synchronized void bar(A a)//同步监视器：b
    {
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了B实例的bar方法");
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用A实例的last方法");
        a.last();
    }

    public synchronized void last()//同步监视器：b
    {
        System.out.println("进入B类的last方法内部");
    }
}
public class DeadLock implements Runnable
{
    A a = new A();
    B b = new B();

    public void init()
    {
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入主线程之后");
    }
    @Override
    public void run()
    {
        Thread.currentThread().setName("副线程");
        //调用b对象的bar方法
        b.bar(a);
        System.out.println("进入副线程之后");
    }

    public static void main(String[] args)
    {
        DeadLock d1 = new DeadLock();
        new Thread(d1).start();

        d1.init();
    }
}
