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
 * @date 2021/3/6 15:26
 */
public class TCPTest3
{
    @Test
    public void client() throws IOException
    {
        //1.创建Socket对象，指明服务器的ip和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.获取输出流
        OutputStream os = socket.getOutputStream();
        //3.获取输入流
        FileInputStream fis = new FileInputStream(new File("1jwjzv.jpg"));
        //4.读取输入流的数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1)
        {
            os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();
        //5.接受来自服务器端的数据，并显示到控制台上
        InputStream is  = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[20];
        int leng;
        while ((leng = is.read(buf)) != -1)
        {
            baos.write(buf,0,leng);
        }
        System.out.println(baos.toString());

        //6.资源的关闭
        fis.close();
        os.close();
        socket.close();
        is.close();
        baos.close();
    }

    @Test
    public void server() throws IOException
    {
        //1.创建服务器的ServerSocket对象，指明自己的端口号
        ServerSocket ss = new ServerSocket(9090);
        //2.调用accept()表示接受来自客户端的socket
        Socket socket = ss.accept();
        //3.获取输入流
        InputStream is = socket.getInputStream();
        //4.获取输出流
        FileOutputStream fos = new FileOutputStream(new File("1jwjzv3.jpg"));

        //5.读写文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1)
        {
            fos.write(buffer,0,len);
        }

        //6.服务器端给予反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，照片已收到！".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}
