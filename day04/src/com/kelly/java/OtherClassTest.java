package com.kelly.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/20 14:22
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */
public class OtherClassTest
{
    @Test
    public void test1()
    {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version：" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java.home：" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("osName：" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version：" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("os的name：" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home：" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir：" + userDir);
    }

    @Test
    public void test2()
    {
        BigInteger bi = new BigInteger("124767433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));

    }
}


