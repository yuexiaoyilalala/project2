package com.kelly.java;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/5 12:34
 * 1.jdk7.0时，引入了Path、Paths、Files三个类
 * 2.此三个类声明在：java.nio.file包下
 * 3.Path可以看做是java.io.File类的升级版本，也可以表示文件或文件目录，与平台无关
 * 4.如何实例化Path：使用Paths
 * static Path get(String first,String ... more)：用于将多个字符串串成路径
 * static Path get(URI uri)：返回指定uri对应的Path路径
 */
public class PathTest
{
    //如何使用Paths实例化Path
    @Test
    public void test1()
    {
        Path path1 = Paths.get("d:\\nio\\hello.txt");

        Path path2 = Paths.get("d:\\","nio\\hello.txt");

        System.out.println(path1);
        System.out.println(path2);

        Path path3 = Paths.get("d:\\", "nio");
        System.out.println(path3);
    }

    //Path中常用方法
    @Test
    public void test2()
    {
        Path path1 = Paths.get("d:\\","nio\\nio1\\nio2\\hello.txt");

        Path path2 = Paths.get("hello.txt");

        //String toString()：返回调用Path对象的字符串表示形式
        System.out.println(path1);//d:\nio\nio1\nio2\hello.txt

        //boolean startsWith(String path):判断是否以path路径开始
        System.out.println(path1.startsWith("d:\\nio"));//true

        //boolean endsWith(String path):判断是否以path路径结束
        System.out.println(path1.endsWith("hello.txt"));//true

        //boolean isAbsolute():判断是否是绝对路径
        System.out.println(path1.isAbsolute() + "~");//true~
        System.out.println(path2.isAbsolute() + "~");//false~

        //Path getParent():返回Path对象包含整个路径，不包含Path对象指定的文件路径
        System.out.println(path1.getParent());//d:\nio\nio1\nio2
        System.out.println(path2.getParent());//null

        //Path getRoot():返回调用Path对象的根路径
        System.out.println(path1.getRoot());//d:\
        System.out.println(path2.getRoot());//null

        //Path getFileName():返回与调用Path对象关联的文件名
        System.out.println(path1.getFileName() + "~");//hello.txt~
        System.out.println(path2.getFileName() + "~");//hello.txt~

        //int getNameCount():返回Path根目录后面元素的数量
        //Path getName(int idx):返回指定索引位置idx的路径名称
        for (int i = 0; i < path1.getNameCount(); i++)
        {
            System.out.println(path1.getName(i) + "******");
            /*
            nio******
            nio1******
            nio2******
            hello.txt******
             */
        }

        //Path toAbsolutePath():作为绝对路径返回调用Path对象
        System.out.println(path1.toAbsolutePath());//d:\nio\nio1\nio2\hello.txt
        System.out.println(path2.toAbsolutePath());//G:\Jetbrains\project2\day10\hello.txt

        //Path resolve(Path p):合并两个路径，返回合并后的路径对应的Path对象
        Path path3 = Paths.get("d:\\","nio");
        Path path4 = Paths.get("nioo\\hi.txt");

        path3 = path3.resolve(path4);
        System.out.println(path3);//d:\nio\nioo\hi.txt

        //File toFile:将Path转化为File类的对象
        File file = path1.toFile();//Path ---> File的转换

        Path newPath = file.toPath();//File ---> Path的转换
    }
}


