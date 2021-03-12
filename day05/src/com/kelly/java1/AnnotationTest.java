package com.kelly.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/1/21 23:07
 */
public class AnnotationTest
{
    public static void main(String[] args)
    {
        Person p = new Student();
        p.walk();
        Date date = new Date(2020,10,11);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;
        //System.out.println(num);

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();

    }
    @Test
    public void testGetAnnotation()
    {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++)
        {
            System.out.println(annotations[i]);
        }
    }
}
//jdk 8之前的写法
//@MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "hi")})
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person
{
    private String name;
    private int age;

    public Person()
    {

    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void walk()
    {
        System.out.println("人走路");
    }

    public void eat()
    {
        System.out.println("人吃饭");
    }
}

interface Info
{
    void show();
}

class Student extends Person implements Info
{
    @Override
    public void walk()
    {
        System.out.println("学生走路");
    }

    @Override
    public void show()
    {

    }
}

class Generic<@MyAnnotation T>
{
     public void show() throws @MyAnnotation RuntimeException
     {
         ArrayList<@MyAnnotation String> list = new ArrayList <>();
         int num = (@MyAnnotation int)10L;


     }
}





