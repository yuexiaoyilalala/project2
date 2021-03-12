package com.kelly.java1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/6 21:53
 */
public class URLTest1
{
    public static void main(String[] args)
    {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try
        {
            URL url = new URL("http://localhost:8080/examples/1jwjzv.jpg");

            urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();

            fos = new FileOutputStream("day10//1jwjzv4.jpg");

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
            //关闭资源
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
        }

        if(urlConnection != null)
            urlConnection.disconnect();
    }
}
