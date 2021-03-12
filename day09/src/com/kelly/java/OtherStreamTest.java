package com.kelly.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/2 22:56
 */
public class OtherStreamTest
{
    public static void main(String[] args)
    {
        BufferedReader br = null;
        try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true)
            {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data))
                {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2()
    {
        PrintStream ps = null;
        try
        {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            //创建打印输出流，设置为自动刷新模式（写入换行符或字节'\n'时都会刷新输出缓冲区）
            ps = new PrintStream(fos,true);
            if(ps != null)
            {
                //把标准输出流（控制台输出）改成文件
                System.setOut(ps);
            }

            for (int i = 0; i <= 255 ; i++)
            {
                //输出ASCII字符
                System.out.print((char)i);
                //每50个数据一行
                if(i % 50 == 0)
                {
                    //换行
                    System.out.println();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(ps != null)
                ps.close();
        }
    }

    @Test
    public void test3()
    {
        DataOutputStream dos = null;
        try
        {
            //1.
            dos = new DataOutputStream(new FileOutputStream("data.txt"));

            //2.
            dos.writeUTF("啦啦啦");
            dos.flush();//刷新操作，将内存中的数据写入文件
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //3.
            if(dos != null)
            {
                try
                {
                    dos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4()
    {
        DataInputStream dis = null;
        try
        {
            //1.
            dis = new DataInputStream(new FileInputStream("data.txt"));

            //2.
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale " + isMale);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
        //3.
        if(dis != null)
        {
            try
            {
                dis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        }
    }
}

