package kelly.java;

import java.util.ArrayList;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/11 16:20
 */
public class HelloWorld
{
    //psvm
    public static void main(String[] args)
    {
        //sout
        System.out.println();
        //soutp
        System.out.println("args = [" + args + "]");
        //soutm
        System.out.println("HelloWorld.main");
        String str1 = "";
        //soutv
        System.out.println("str1 = " + str1);
        //xxx.sout
        System.out.println("hello");
        //��ͨforѭ��������fori
        for (int i = 0; i < 5; i++)
        {

        }
        //��ǿforѭ����iter
        for (String arg : args)
        {
            System.out.println();
        }
        //�оֲ���������ͨforѭ��������itar
        for (int i = 0; i < args.length; i++)
        {
            String arg = args[i];
            
        }
        //�ж��Ƿ�Ϊnull��ifn
        if (args == null)
        {

        }
        //�ж��Ƿ�Ϊ�գ�inn
        if (str1 != null)
        {

        }
        //�ж�ָ�������Ƿ�Ϊ�գ�xxx.null
        if (str1 == null)
        {

        }
        //�ж�ָ�������Ƿ�ǿգ�xxx.nn
        if (str1 != null)
        {

        }
        //�Զ����ɷ���ֵxxx.var
        String jack = "jack";
        //ǿת��xxx.cast
        Object list = new ArrayList();
        ArrayList list1 = (ArrayList) list;
    }
    //����ֵ��xxx.return
    public static  String test()
    {
        return "hello";
    }
}

class Foo
{
    //public static final��psf
    public static final int a1 = 0;
    //private static final��prsf
    private static final int a2 = 0;
    //public static final int��psfi
    public static final int a3 = 0;
    //public static final String��psfs
    public static final String a4 = "hello";
}

