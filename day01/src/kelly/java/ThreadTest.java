package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/11 22:37
 */
//����100���ڵ�����ż��
//1. ����һ���̳���Thread�������
class MyThread extends Thread
{
    //2. ��дThread���run()-->�����̵߳Ĳ���������run()��
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
        //3. ����Thread������Ķ���
        MyThread t1 = new MyThread();
        //4. ͨ���˶������start():��������ǰ�̢߳ڵ��õ�ǰ�̵߳�run()
        t1.start();
        //����һ������ͨ��ֱ�ӵ���run()�����ķ�ʽ�����߳�
        //t1.run();
        //�������������һ���̣߳�����100���ڵ�ż��
        //���������Ѿ�start()���߳�ȥִ�У��ᱨIllegalThread�쳣
        //t1.start();
        //��Ҫ���´���һ���̵߳Ķ���
        MyThread t2 = new MyThread();
        t2.start();
        //���²���������main�߳���ִ�е�
        for (int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i + "********************");
            }
        }

    }
}
