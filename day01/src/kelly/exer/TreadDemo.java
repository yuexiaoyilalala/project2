package kelly.exer;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 12:49
 */
public class TreadDemo
{
    public static void main(String[] args)
    {
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//
//        m1.start();
//        m2.start();
        //创建Thread匿名子类的方式
        new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 100; i++)
                {
                    if(i % 2 == 0)
                    {
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                    }
                }
            }
        }.start();

        new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 100; i++)
                {
                    if(i % 2 != 0)
                    {
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                    }
                }
            }
        }.start();
    }
}
//class MyThread1 extends Thread
//{
//    @Override
//    public void run()
//    {
//        for (int i = 0; i < 100; i++)
//        {
//            if(i % 2 == 0)
//            {
//                System.out.println(Thread.currentThread().getName()+ ":" + i);
//            }
//        }
//    }
//}
//class MyThread2 extends Thread
//{
//    @Override
//    public void run()
//    {
//        for (int i = 0; i < 100; i++)
//        {
//            if(i % 2 != 0)
//            {
//                System.out.println(Thread.currentThread().getName()+ ":" + i);
//            }
//        }
//    }
//}

