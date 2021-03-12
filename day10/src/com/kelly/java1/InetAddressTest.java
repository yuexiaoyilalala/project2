package com.kelly.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/5 15:27
 */
public class InetAddressTest
{
    public static void main(String[] args)
    {
        InetAddress inet1 = null;
        InetAddress inet2 = null;
        InetAddress inet3 = null;
        InetAddress inet4 = null;
        try
        {
            inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);///192.168.10.14

            inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);//www.atguigu.com/36.158.217.188

            inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);///127.0.0.1

            //获取本地ip
            inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);//localhost/127.0.0.1

            //getHostName()
            System.out.println(inet2.getHostName());//www.atguigu.com

            //getHostAddress()
            System.out.println(inet2.getHostAddress());//36.158.217.188
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }

    }
}


