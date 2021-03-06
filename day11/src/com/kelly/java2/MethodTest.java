package com.kelly.java2;

import com.kelly.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/11 20:36
 */
public class MethodTest
{
    @Test
    public void test1()
    {
        Class clazz = Person.class;

        //getMethods():获取当前运行时类及其父类中声明为public访问权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m  : methods)
        {
            System.out.println(m);
        }

        System.out.println("*******************************");

        //getDeclaredMethods():获取当前运行时类中声明的所有方法（不包含父类中声明的属性）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods)
        {
            System.out.println(m);
        }
    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名（参数类型1  形参1 ，...） throws XxxException{}
     */
    @Test
    public void test2()
    {
        Class clazz = Person.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods)
        {
            //1.获取方法声明的注释
            Annotation[] annos = m.getAnnotations();
            for (Annotation an : annos)
            {
                System.out.print(an + "\t");
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");

            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0))
            {
                for(int i = 0;i < parameterTypes.length;i++)
                {
                    if(i == parameterTypes.length - 1)
                    {
                        System.out.print("args_" + i  + ":" + parameterTypes[i].getName());
                        break;
                    }
                    System.out.print("args_" + i  + ":" + parameterTypes[i].getName() + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            //if( exceptionTypes.length > 0)
            if(!(exceptionTypes == null || exceptionTypes.length == 0))
            {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++)
                {
                    if(i == exceptionTypes.length - 1)
                    {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
                System.out.println();
        }
    }
}


