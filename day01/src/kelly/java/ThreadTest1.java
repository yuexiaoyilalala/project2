package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 21:58
 */
//1. ����һ��ʵ��Runnable�ӿڵ���
class MThread implements Runnable
{
    //2. ʵ����ȥʵ��Runnable�еĳ��󷽷���run()
    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            if (i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest1
{
    public static void main(String[] args)
    {
        //3. ����ʵ����Ķ���
        MThread mThread = new MThread();
        //4. ���˶�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread��Ķ���
        Thread t1 = new Thread(mThread);
        t1.setName("�߳�1");
        //5. ͨ��Thread��Ķ������start()
        t1.start();

        //������һ���̣߳�����100���ڵ�ż��
        Thread t2 = new Thread(mThread);
        t2.setName("�߳�2");
        t2.start();
    }
}
