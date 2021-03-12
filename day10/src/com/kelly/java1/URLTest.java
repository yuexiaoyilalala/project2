package com.kelly.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/6 20:15
 */
public class URLTest
{
    public static void main(String[] args)
    {
        URL url;

        {
            try
            {
                url = new URL("http://localhost:8080/examples/1jwjzv.jpg");
                //获取该URL的协议名
                System.out.println(url.getProtocol());//https
                //获取该URL的主机名
                System.out.println(url.getHost());//localhost
                //获取该URL的端口号
                System.out.println(url.getPort());//8080
                //获取该URL的文件路径
                System.out.println(url.getPath());// /examples/1jwjzv.jpg
                //获取该URL的文件名
                System.out.println(url.getFile());// /examples/1jwjzv.jpg
                //获取该URL的查询名
                System.out.println(url.getQuery());//null
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
