package com.kelly.java4;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/19 16:25
 */
public class Boy
{
    private Girl girl;

    public Boy()
    {

    }

    public Boy(Girl girl)
    {
        this.girl = girl;
    }

    public Girl getGirl()
    {
        return girl;
    }

    public void setGirl(Girl girl)
    {
        this.girl = girl;
    }

    @Override
    public String toString()
    {
        return "Boy{" + "girl=" + girl + '}';
    }
}
