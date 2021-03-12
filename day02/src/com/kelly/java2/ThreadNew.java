package com.kelly.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/14 14:55
 */
//1.����һ��ʵ��Callable�ӿڵ�ʵ����
class NumThread implements Callable
{
    //2.ʵ��call()�����������߳���Ҫִ�еĲ���������call()������
    @Override
    public Object call() throws Exception
    {
        int sum = 0;
        for (int i = 1; i <= 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew
{
    public static void main(String[] args)
    {
        //3.����Callable�ӿ�ʵ����Ķ���
        NumThread numThread = new NumThread();
        //4.����Callable�ӿ�ʵ����Ķ�����Ϊ�������ݵ�FutureTask�������У�����FutureTask�Ķ���
        FutureTask futureTask = new FutureTask(numThread);
        //5.��FutureTask�Ķ�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread���󣬲�����start()
        new Thread(futureTask).start();
        try
        {
            //6.��ȡCallable()��call()�����ķ���ֵ
            //get()����ֵ��ΪFutureTask������Callableʵ������д��call()�ķ���ֵ
            Object sum = futureTask.get();
            System.out.println("�ܺ�Ϊ��" + sum);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}
