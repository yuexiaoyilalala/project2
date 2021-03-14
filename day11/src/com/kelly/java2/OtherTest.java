package com.kelly.java2;

import com.kelly.java1.Person;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/12 11:48
 */
public class OtherTest
{
    /*
    获取构造器
     */
    @Test
    public void test1()
    {
        Class clazz = Person.class;

        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors)
        {
            System.out.println(c);//public com.kelly.java1.Person()
        }

        System.out.println("***************************");

        //getDeclaredConstructors():获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors)
        {
            System.out.println(c);
            /*
            public com.kelly.java1.Person()
            com.kelly.java1.Person(java.lang.String,int)
            private com.kelly.java1.Person(java.lang.String)
             */
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2()
    {
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);//class com.kelly.java1.Creature
    }

    /*
    获取运行时类带泛型的父类
    */
    @Test
    public void test3()
    {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);//com.kelly.java1.Creature<java.lang.String>
    }

    /*
    获取运行时类带泛型的父类的泛型
   */
    @Test
    public void test4()
    {
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType)genericSuperclass;
        //获取泛型参数
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());//java.lang.String
        System.out.println(((Class)actualTypeArguments[0]).getName());//java.lang.String
    }

    /*
   获取运行时类实现的接口
  */
    @Test
    public void test5()
    {
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces)
        {
            System.out.println(c);
            /*
            interface java.lang.Comparable
            interface com.kelly.java1.MyInterface
             */
        }

        System.out.println("**********************");

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1)
        {
            System.out.println(c);//interface java.io.Serializable
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6()
    {
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);//package com.kelly.java1
    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test7()
    {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations)
        {
            System.out.println(annos);//@com.kelly.java1.MyAnnotation(value=hi)
        }
    }
}

