package com.kelly.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/17 19:57
 */
public class StringDemo2
{
    public String getMaxSameString(String str1,String str2)
    {
       if(str1 != null && str2 !=null)
       {
           String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
           String minStr = (str1.length() < str2.length()) ? str1 : str2;
           int length = minStr.length();
           for (int i = 0; i < length; i++)
           {
               for (int x = 0,y = length - i; y <= length ; x++,y++)
               {
                   String subStr = minStr.substring(x,y);
                   if(maxStr.contains(subStr))
                   {
                       return subStr;
                   }
               }
           }
       }
       return null;
    }

    //如果存在多个长度相同的最大相同子串
    //此时先返回String[],后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1,String str2)
    {
        if(str1 != null && str2 !=null)
        {
            StringBuffer sBuffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++)
            {
                for (int x = 0,y = length - i; y <= length ; x++,y++)
                {
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr))
                    {
                        sBuffer.append(subStr + ",");
                    }
                }
                if(sBuffer.length() != 0)
                {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void testGetMaxSameString()
    {
        String str1 = "abcwerthelloyuiodefabcde";
        String str2 = "cvhellobnmabcde";
        String[] maxSameString1 = getMaxSameString1(str1,str2);
        System.out.println(Arrays.toString(maxSameString1));
    }
}

