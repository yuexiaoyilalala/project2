package com.kelly.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/14 16:10
 */
class NumberThread implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i <= 100; i++)
        {
            if (i % 2 != 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool
{
    public static void main(String[] args)
    {
        //1. �ṩָ���߳��������̳߳�
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        //�����̳߳ص�����
        //System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();
        //2. ִ��ָ�����̵߳Ĳ�������Ҫ�ṩʵ��Runnable()�ӿڻ�Callable()�ӿ�ʵ����Ķ���
        service.execute(new NumberThread());//�ʺ�ʹ����Runnable
        service.execute(new NumberThread1());
        //service.submit(Callable callable);//�ʺ�ʹ����Callable
        //3. �ر����ӳ�
        service.shutdown();
    }
}

