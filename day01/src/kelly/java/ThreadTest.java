package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/11 22:37
 */
//遍历100以内的所有偶数
//1. 创建一个继承于Thread类的子类
class MyThread extends Thread
{
    //2. 重写Thread类的run()-->将此线程的操作声明在run()中
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i );
            }
        }
    }
}
public class ThreadTest
{
    public static void main(String[] args)
    {
        //3. 创建Thread类子类的对象
        MyThread t1 = new MyThread();
        //4. 通过此对象调用start():①启动当前线程②调用当前线程的run()
        t1.start();
        //问题一：不能通过直接调用run()方法的方式启动线程
        //t1.run();
        //问题二：再启动一个线程，遍历100以内的偶数
        //不可以让已经start()的线程去执行，会报IllegalThread异常
        //t1.start();
        //需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();
        //如下操作仍是在main线程中执行的
        for (int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i + "********************");
            }
        }

    }
}
