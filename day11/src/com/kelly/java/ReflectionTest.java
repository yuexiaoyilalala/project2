package com.kelly.java;

import org.junit.Test;

import javax.xml.bind.Element;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/10 20:17
 */
public class ReflectionTest
{
    //反射之前，对应Person的操作
    @Test
    public void test1()
    {
        //1.创建Person类的对象
        Person p1 = new Person("Tom",12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如在name、showNation()以及私有的构造器

    }

    //反射之后，
    @Test
    public void test2() throws Exception
    {
         Class clazz = Person.class;
         //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());//Person{name='Tom', age=12}

        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());//Person{name='Tom', age=10}

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);//你好！

        System.out.println("*********************************");

        //通过反射，可以调用Person类的私有结构，比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);//Person{name='Jerry', age=0}

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"lalala");
        System.out.println(p1);//Person{name='lalala', age=0}

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于p1.showNation("中国");//我的国籍是：中国
        System.out.println(nation);//中国
    }

    /*
    获取Class的实例的方式(前三种方式需要掌握)
     */
    @Test
    public void test3() throws ClassNotFoundException
    {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);//class com.kelly.java.Person

        //方式二：调用运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);//class com.kelly.java.Person

        //方式三：调用Class的静态方法：forName(String classPath)
        //体现反射的动态性
        Class clazz3 = Class.forName("com.kelly.java.Person");
        System.out.println(clazz3);//class com.kelly.java.Person

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true

        //方式四：使用类的加载器：ClassLoader(了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.kelly.java.Person");
        System.out.println(clazz4);//class com.kelly.java.Person

        System.out.println(clazz1 == clazz4);//true
    }

    //Class实例可以是哪些结构的说明
    @Test
    public void test4()
    {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);//true
    }

}
