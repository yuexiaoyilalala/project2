package com.kelly.java;

import org.junit.Test;


import java.io.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/4 13:37
 */
public class ObjectInputOutputStreamTest
{
    /*
    序列化过程：将内存中的java对象保存到磁盘或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream()
    {
        ObjectOutputStream oos = null;
        try
        {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱北京"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("啦啦啦",25));
            oos.flush();//刷新操作

            oos.writeObject(new Person("哈哈哈",25,1004,new Account(5000)));
            oos.flush();//刷新操作

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(oos != null)
                //3.
            {
                try
                {
                    oos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化过程：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream()
    {
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String)obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(ois != null)
            {
                try
                {
                    ois.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
