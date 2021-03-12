package kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/12 18:56
 */
public class WindowTest
{
    public static void main(String[] args)
    {
        Windows t1 = new Windows();
        Windows t2 = new Windows();
        Windows t3 = new Windows();

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Windows extends Thread
{
    private static int ticket = 100;

    @Override
    public void run()
    {
        while (true)
        {
            if(ticket > 0)
            {
                System.out.println(getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
                ticket--;
            }
            else
            {
                break;
            }
        }
    }
}

