package com.kelly.exer;

import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/17 15:50
 */
public class StringDemo
{
    /*
    方式一：转换为char[]
     */
    public String reverse(String str,int startIndex,int endIndex)
    {
        if(str != null)
        {
            char[] arr = str.toCharArray();
            for(int x = startIndex,y = endIndex;x < y;x++,y--)
            {
                char temp = arr[x];
                arr[x] = arr [y];
                arr [y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex)
    {
       if(str != null)
       {
           //第一部分
           String reverseStr = str.substring(0,startIndex);
           //第二部分
           for(int i = endIndex;i >= startIndex;i--)
           {
               reverseStr += str.charAt(i);
           }
           //第三部分
           reverseStr += str.substring(endIndex + 1);
           return reverseStr;
       }
       return  null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex)
    {
        if(str != null)
        {
            StringBuilder builder = new StringBuilder(str.length());
            //第一部分
            builder.append(str.substring(0,startIndex));
            //第二部分
            for(int i = endIndex;i >= startIndex;i--)
            {
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse()
    {
        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
        String reverse1 = reverse1(str, 2, 5);
        System.out.println(reverse1);
        String reverse2 = reverse2(str, 2, 5);
        System.out.println(reverse2);
    }
}

