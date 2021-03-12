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
        //普通for循环遍历：fori
        for (int i = 0; i < 5; i++)
        {

        }
        //增强for循环：iter
        for (String arg : args)
        {
            System.out.println();
        }
        //有局部变量的普通for循环遍历：itar
        for (int i = 0; i < args.length; i++)
        {
            String arg = args[i];
            
        }
        //判断是否为null：ifn
        if (args == null)
        {

        }
        //判断是否不为空：inn
        if (str1 != null)
        {

        }
        //判断指定内容是否为空：xxx.null
        if (str1 == null)
        {

        }
        //判断指定内容是否非空：xxx.nn
        if (str1 != null)
        {

        }
        //自动生成返回值xxx.var
        String jack = "jack";
        //强转：xxx.cast
        Object list = new ArrayList();
        ArrayList list1 = (ArrayList) list;
    }
    //返回值：xxx.return
    public static  String test()
    {
        return "hello";
    }
}

class Foo
{
    //public static final：psf
    public static final int a1 = 0;
    //private static final：prsf
    private static final int a2 = 0;
    //public static final int：psfi
    public static final int a3 = 0;
    //public static final String：psfs
    public static final String a4 = "hello";
}

