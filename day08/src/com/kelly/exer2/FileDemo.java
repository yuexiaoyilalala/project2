package com.kelly.exer2;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/19 13:22
 */
public class FileDemo
{
    @Test
    public void test1() throws IOException
    {
        File file = new File("D:\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile)
        {
            System.out.println("创建成功！");//创建成功！
        }
    }

    @Test
    public void test2()
    {
        File file = new File("D:\\io\\io1\\io3");
        String[] list = file.list();
        for (String s : list)
        {
            if(s.endsWith(".JPG"))
            {
                System.out.println(s);//capture.JPG
            }
        }
    }

    @Test
    public void test3()
    {
        File srcFile = new File("D:\\io\\io1\\io3");
        File[] listFiles = srcFile.listFiles();
        for (File file : listFiles)
        {
            if(file.getName().endsWith(".JPG"))
            {
                System.out.println(file.getAbsolutePath());//D:\io\io1\io3\capture.JPG
            }
        }
    }

    /*
    File类提供了两个文件过滤器方法
    public String[] list(FilenameFilter filter)
    public File[] listFiles(FileFilter filter)
     */
    @Test
    public void test4()
    {
        File srcFile = new File("D:\\io\\io1\\io3");
        File[] subFiles = srcFile.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".JPG");
            }
        });
        for (File file : subFiles)
        {
            System.out.println(file.getAbsolutePath());//D:\io\io1\io3\capture.JPG
        }
    }

    //拓展1：求指定目录所在空间的大小
    @Test
    public void test5()
    {
        File file = new File("G:\\Jetbrains\\Java");
        long directorySize = getDirectorySize(file);
        System.out.println(directorySize);

    }

    public long getDirectorySize(File file)
    {
        //file是文件，那么直接返回file.length()
        //file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if(file.isFile())
        {
            size += file.length();
        }
        else
        {
            File[] all = file.listFiles();//获取file的下一级
            //累计all[i]的大小
            for (File f : all)
            {
                size += getDirectorySize(f);//f的大小
            }
        }
        return size;
    }

    //拓展2：删除指定的目录
    @Test
    public void test6()
    {
        File file = new File("D:\\io");
        deleteDirectory(file);
    }

    public void deleteDirectory(File file)
    {
        //file是文件，那么直接delete
        //file是目录，把它的下一级删掉，然后删除自己
        if(file.isDirectory())
        {
            File[] all = file.listFiles();
            //循环删除的是file的下一级
            for(File f : all)//f代表file的每一个下级
            {
                deleteDirectory(f);
            }
        }
        //删除自己
        file.delete();
    }
}

