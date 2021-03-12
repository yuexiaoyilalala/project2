package com.kelly.java;

import org.junit.Test;

import java.io.*;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/2 23:29
 */
public class InputStreamReaderTest
{
    /*
    此时处理异常的话，仍然使用try-catch-finally
    InputStreamReader的使用，实现字节的输入流到字符的输入流转换
     */
    @Test
    public void test1() throws IOException
    {
        FileInputStream fis = new FileInputStream("dbcp.txt");
        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用了哪个字符集，取决于文件dbcp.txt保存时使用的字符集
        //InputStreamReader isr = new InputStreamReader(fis,"UTF-8");//使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1)
        {
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }
        isr.close();
    }

    /*
    此时处理异常的话，仍然使用try-catch-finally
    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() throws Exception
    {
        //1.造文件、造流
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1)
        {
            osw.write(cbuf,0,len);
        }

        //3.关闭资源
        osw.close();
        isr.close();
    }
}
