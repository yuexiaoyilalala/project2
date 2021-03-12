package com.kelly.java2;

import com.kelly.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.Format;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/11 19:56
 * 获取运行时类的属性结构
 */
public class FileldTest
{
    @Test
    public void test1()
    {
        Class clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields)
        {
            System.out.println(f);
            /*
            public int com.kelly.java1.Person.id
            public double com.kelly.java1.Creature.weight
             */
        }

        System.out.println("*******************************");

        //getDeclaredFields:获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields)
        {
            System.out.println(f);
            /*
            private java.lang.String com.kelly.java1.Person.name
            int com.kelly.java1.Person.age
            public int com.kelly.java1.Person.id
             */
        }
    }

    //权限修饰符  数据类型 变量名
    @Test
    public void test2()
    {
        Class clazz = Person.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields)
        {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);

            System.out.println();
            /*
            private	java.lang.String	name
	                        int	age
            public	int	id
             */
        }
    }
}
