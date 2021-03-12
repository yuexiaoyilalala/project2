package com.kelly.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/6 14:43
 */
public class TCPTest2
{
    @Test
    public void client()
    {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try
        {
            //1.创建Socket对象，指明服务器的ip和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            //2.获取输出流
            os = socket.getOutputStream();
            //3.获取输入流
            fis = new FileInputStream(new File("1jwjzv.jpg"));
            //4.读取输入流的数据
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1)
            {
                os.write(buffer,0,len);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
        }
        //5.资源的关闭
        if(fis != null)
        {
            try
            {
                fis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(os != null)
        {
            try
            {
                os.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(socket != null)
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server()
    {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try
        {
            //1.创建服务器的ServerSocket对象，指明自己的端口号
            ss = new ServerSocket(9090);
            //2.调用accept()表示接受来自客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.获取输出流
            fos = new FileOutputStream(new File("1jwjzv2.jpg"));

            //5.读写文件
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1)
            {
                fos.write(buffer,0,len);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
        }
        //6.关闭资源
        if(fos != null)
        {
            try
            {
                fos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(is != null)
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(socket != null)
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(ss != null)
        {
            try
            {
                ss.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
