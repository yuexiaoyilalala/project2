package com.kelly.exer2;

import java.io.File;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/19 14:27
 */
public class ListFileTest
{
    public static void main(String[] args)
    {
        //递归：文件目录
        /**
         打印出指定目录所有文件名称，包括子文件目录中的文件
         */

        //1.创建目录对象
        File dir = new File("G:\\Jetbrains\\Java");

        //2.打印目录的子文件
        printSubFile(dir);

    }

    public static void printSubFile(File dir)
    {
        //打印目录的子文件
        File[] subfiles = dir.listFiles();

        for (File f : subfiles)
        {
            if(f.isDirectory())//文件目录
            {
                printSubFile(f);
            }
            else //文件
            {
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    //或
    //列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    //建议使用File类的File[] listFile[]
    public void listAllSubFiles(File file)
    {
        if(file.isFile())
        {
            System.out.println(file);
        }
        else
        {
            File[] all = file.listFiles();
            //如果all[i]是文件，直接打印
            //如果all[i]是目录，接着再获得它的下一级
            for (File f : all)
            {
                listAllSubFiles(f);//递归调用：自己调用自己就叫做递归
            }
        }

    }
}

