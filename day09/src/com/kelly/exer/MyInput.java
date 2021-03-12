package com.kelly.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/3 15:16
 */
public class MyInput
{
    public static String readString()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = "";

        try
        {
            string = br.readLine();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return string;
    }

    public static int readInt()
    {
        return Integer.parseInt(readString());
    }

    public static double readDouble()
    {
        return Double.parseDouble(readString());
    }

    public static float readFloat()
    {
        return Float.parseFloat(readString());
    }

    public static boolean readBoolean()
    {
        return Boolean.parseBoolean(readString());
    }

    public static short readShort()
    {
        return Short.parseShort(readString());
    }

    public static byte readByte()
    {
        return Byte.parseByte(readString());
    }
}

