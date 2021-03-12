package com.kelly.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/4 16:35
 */
public class RandomAccessFileTest
{
    @Test
    public void test1()
    {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try
        {
            //1.
            raf1 = new RandomAccessFile(new File("1jwjzv.jpg"),"r");
            raf2 = new RandomAccessFile(new File("1jwjzv1.jpg"),"rw");

            //2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1)
            {
                raf2.write(buffer,0,len);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //3.
            if(raf2 != null)
            {
                try
                {
                    raf2.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if(raf1 != null)
            {
                try
                {
                    raf1.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException
    {
        File file = new File("hello.txt");
        RandomAccessFile raf1 = new RandomAccessFile(file,"rw");

        //raf1.seek(file.length());
        raf1.seek(3);//将指针调到角标为3的位置(执行覆盖操作)
        raf1.write("xyz".getBytes());

        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException
    {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置

        //保存指针3后面的所有数据到StringBuilder
        StringBuilder builder = new StringBuilder((int)new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1)
        {
            builder.append(new String(buffer,0,len));
        }

        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

    }

    /*
    将StringBuilder替换为ByteArrayOutputStream
     */
    @Test
    public void test4() throws IOException
    {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置
        ByteArrayOutputStream baos = new ByteArrayOutputStream((int)new File("hello.txt").length());

        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1)
        {
            baos.write(buffer,0,len);
        }

        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        raf1.write(baos.toString().getBytes());
        raf1.close();
    }
}
