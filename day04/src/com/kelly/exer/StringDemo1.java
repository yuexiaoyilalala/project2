package com.kelly.exer;

import org.junit.Test;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/17 16:29
 */
public class StringDemo1
{
    /**
     * Description:
    * @param mainStr
    * @param subStr
     * @return int
     */

    public int getCount(String mainStr,String subStr)
    {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength)
        {
            //方式一：
//            while ((index = mainStr.indexOf(subStr)) != -1)
//            {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式二：方式一的改进
            while ((index = mainStr.indexOf(subStr,index)) != -1)
            {
                count++;
                index += subLength;
            }
            return count;
        }
        else
        {
            return 0;
        }
    }

    @Test
    public void testGetCount()
    {
        String mainStr = "abkkcadkabkebfkaabkskab";
        String subStr = "ab";
        int count = getCount(mainStr,subStr);
        System.out.println(count);
    }
}

