package com.kelly.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/10 16:15
 */
public class FileTest
{
    /*
    1.如何创建File类的实例
      File(String filePath)
      File(String parentPath,String childPath)
      File(File parentFile,String childPath)
    2.相对路径：相较于某个路径下，指明的路径
      绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
      windows:\\
      unix:/
     */

    @Test
    public void test1()
    {
        //构造器1
        File file1 = new File("hello.txt");//相当于当前module
        File file2 = new File("G:\\Jetbrains\\project2\\day08\\he.txt");

        System.out.println(file1);//hello.txt
        System.out.println(file2);//G:\Jetbrains\project2\day08\he.txt

        //构造器2
        File file3 = new File("G:\\Jetbrains","project2");
        System.out.println(file3);//G:\Jetbrains\project2

        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);//G:\Jetbrains\project2\hi.txt
    }

    /*
    public String getAbsolutePath():获取绝对路径
    public String getPath():获取路径
    public String getName():获取名称
    public String getParent():获取上层文件目录路径。若无，返回null
    public long length():获取文件长度（即：字节数）。不能获取目录的长度
    public long lastModified():获取最后一次的修改时间，毫秒值
    适用于文件目录
    public String[] list():获取指定目录下的所有文件或者文件目录的名称数组
    public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
     */

    @Test
    public void test2()
    {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());//G:\Jetbrains\project2\day08\hello.txt
        System.out.println(file1.getPath());//hello.txt
        System.out.println(file1.getName());//hello.txt
        System.out.println(file1.getParent());//null
        System.out.println(file1.length());//10
        System.out.println(new Date(file1.lastModified()));//Thu Feb 11 20:31:41 CST 2021

        System.out.println();
        System.out.println(file2.getAbsolutePath());//D:\io\hi.txt
        System.out.println(file2.getPath());//D:\io\hi.txt
        System.out.println(file2.getName());//hi.txt
        System.out.println(file2.getParent());//D:\io
        System.out.println(file2.length());//0
        System.out.println(file2.lastModified());//0
    }

    @Test
    public void test3()
    {
        File file = new File("G:\\Jetbrains\\project2");

        String[] list = file.list();
        for (String s : list)
        {
            System.out.println(s);
        }
        System.out.println();
        File[] files = file.listFiles();
        for(File f : files)
        {
            System.out.println(f);
        }
    }

    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如:file1.renameTo(file2)为例，要想保证返回true，需要file1在硬盘中是存在的，且file2不能在硬盘中
     */
    @Test
    public void test4()
    {
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);
    }

    /*
    public boolean isDirectory():判断是否是文件目录
    public boolean isFile():判断是否是文件
    public boolean exists():判断是否存在
    public boolean canRead():判断是否可读
    public boolean canWrite():判断是否可写
    public boolean isHidden():判断是否隐藏
     */
    @Test
    public void test5()
    {
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());//false
        System.out.println(file1.isFile());//true
        System.out.println(file1.exists());//true
        System.out.println(file1.canRead());//true
        System.out.println(file1.canWrite());//true
        System.out.println(file1.isHidden());//false

        System.out.println();

        File file2 = new File("D:\\io");
        System.out.println(file2.isDirectory());//true
        System.out.println(file2.isFile());//false
        System.out.println(file2.exists());//true
        System.out.println(file2.canRead());//true
        System.out.println(file2.canWrite());//true
        System.out.println(file2.isHidden());//false
    }

    /*
    创建硬盘中对应的文件或文件目录
    public boolean createNewFile():创建文件。若文件存在，则不创建，返回false
    public boolean mkdir():创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    public boolean mkdirs():创建文件目录。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
    public boolean delete():删除文件或者文件夹
    删除注意事项:
    Java中的删除不走回收站
     */
    @Test
    public void test6() throws IOException
    {
        File file1 = new File("hi.txt");
        if(!file1.exists())
        {
            //文件创建
            file1.createNewFile();
            System.out.println("创建成功");
        }
        else//文件存在
        {
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7()
    {
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir)
        {
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1)
        {
            System.out.println("创建成功2");//创建成功2
        }

        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("d:\\io\\io1\\io4");
        file3 = new File("d:\\io\\io1");
        System.out.println(file3.delete());
    }
}

