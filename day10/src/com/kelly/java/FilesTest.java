package com.kelly.java;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/5 13:19
 */
public class FilesTest
{
    @Test
    public void test1() throws IOException
    {
        Path path1 = Paths.get("d:nio","hello.txt");
        Path path2 = Paths.get("d:nio","atguigu.txt");
        //Path path2 = Paths.get("atguigu.txt");

        //Path copy(Path src,Path dest,CopyOption ... how):文件的复制
        //要想复制成功，要求path1对应的文件在物理上存在，path2对应的文件没有要求
        Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING);

        //Path createDirectory(Path path,FileAttribute<?> ... attr):创建一个目录
        //要想执行成功，要求path对应的文件在物理上不存在，一旦存在，抛出异常
        Path path3 = Paths.get("d:\\nio\\nio1");
        Files.createDirectory(path3);

        //Path createFile(Path path,FileAttribute<?> ... arr):创建一个文件
        Path path4 = Paths.get("d:nio\\hi.txt");
        Files.createFile(path4);

        //void delete(Path path):删除一个文件、目录，如果不存在，执行报错
        Files.delete(path4);

        //void deleteIfExist(Path path):Path对应的文件、目录如果存在，执行删除
        Files.deleteIfExists(path3);

        //Path move(Path src,Path dest,CopyOption ... how):将src移动到dest位置
        //要想执行成功，src对应的物理上的文件需要存在，dest对应的文件没有要求
        //而且移动和被移动的文件必须在相同的磁盘驱动器
        Files.move(path1,path2,StandardCopyOption.ATOMIC_MOVE);

        //long size(Path path):返回path指定文件的大小
        long size = Files.size(path2);
        System.out.println(size);

    }
}
