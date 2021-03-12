package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/21 15:48
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum类
 */
public class SeasonTest1
{
    public static void main(String[] args)
    {
        Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());//SUMMER
        //System.out.println(summer.getClass().getSuperclass());
        //value():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++)
        {
            System.out.println(values[i]);//SPRING
                                          //SUMMER
                                          //AUTUMN
                                          //WINTER
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++)
        {
            System.out.println(values1[i]);//NEW
                                           //RUNNABLE
                                           //BLOCKED
                                           //WAITING
                                           //TIMED_WAITING
                                           //TERMINATED
        }

        //valueOf(String objName)：返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        //Season1 winter1 = Season1.valueOf("WINTER1");
        System.out.println(winter);//WINTER
        winter.show();//大约在冬季
    }
}

interface Info
{
    void show();
}
//使用enum关键字自定义枚举类
enum Season1 implements Info
{
    //1.提供当前枚举类的对象,多个对象之间用“,”隔开，末尾对象“;”结束
    SPRING("春天","春暖花开")
    {
        @Override
        public void show()
        {
            System.out.println("春天里");
        }
    },
    SUMMER("夏天","夏日炎炎")
    {
        @Override
        public void show()
        {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽")
    {
        @Override
        public void show()
        {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地")
    {
        @Override
        public void show()
        {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc)
    {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName()
    {
        return seasonName;
    }

    public String getSeasonDesc()
    {
        return seasonDesc;
    }


//    @Override
//    public void show()
//    {
//        System.out.println("这是一个季节！");
//    }

    //5.其他诉求2：提供toString()
//    @Override
//    public String toString()
//    {
//        return "Season1{" + "seasonName='" + seasonName + '\'' + ", seasonDesc='" + seasonDesc + '\'' + '}';
//    }


}





















