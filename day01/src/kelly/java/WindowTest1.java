package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 22:31
 */
class Window1 implements Runnable
{
    private int ticket = 100;
    @Override
    public void run()
    {
        while (true)
        {
            if(ticket > 0)
            {
                System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ�� " + ticket);
                ticket--;
            }
            else
            {
                break;
            }
        }
    }
}
public class WindowTest1
{
    public static void main(String[] args)
    {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }
}

