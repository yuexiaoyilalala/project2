package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 13:40
 */
class HelloThread extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 1000; i++)
        {
            if (i % 2 == 0)
            {
//                try
//                {
//                    sleep(10);
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
                System.out.println(getName() +  ":" + getPriority() + ":" + i);
            }
//            if(i % 20 == 0)
//            {
//                yield();
//            }
        }
    }

    public HelloThread(String name)
    {
        super(name);
    }
}
public class ThreadMethodTest
{
    public static void main(String[] args)
    {
        HelloThread h1 = new HelloThread("Thread:1");
        //h1.setName("线程一：");
        //设置分线程优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程：");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 1000; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() +  ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if(i == 20)
//            {
//                try
//                {
//                    h1.join();
//                }
//                catch (InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//            }
        }
//        System.out.println(h1.isAlive());
    }
}
