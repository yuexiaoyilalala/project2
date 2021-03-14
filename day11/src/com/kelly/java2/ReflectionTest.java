package com.kelly.java2;

import com.kelly.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/12 18:27
 */
public class ReflectionTest
{
    /*
    不需要掌握
     */
    @Test
    public void testField() throws Exception
    {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性:要求运行时类中属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
        set():参数1：指明设置哪个对象的属性 参数2：将此属性设置为多少
         */
        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int)id.get(p);
        System.out.println(pId);//1001
    }

    /*
    如何操作运行时类中的指定的属性 ---需要掌握
     */
    @Test
    public void testField1() throws Exception
    {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置当前属性的值
        name.set(p,"Tom");

        System.out.println(name.get(p));//Tom
    }

    /*
    如何操作运行时类中的指定的方法 ---需要掌握
     */

    @Test
    public void testMethod() throws Exception
    {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1：指明获取的方法的名称  参数2：指明获取的方法形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2.保证当前方法时可访问的
        show.setAccessible(true);

        /*
        3.调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值
         */
        Object returnValue = show.invoke(p, "CHN");//String nation = p.show;
                                                          //我的国籍是：CHN
        System.out.println(returnValue);//CHN

        System.out.println("************如何调用静态方法****************");

        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如何调用的运行时类中的方法没有返回值，则此invoke()返回null
        //Object invoke = showDesc.invoke(null);
        Object invoke = showDesc.invoke(Person.class);//可爱的人
        System.out.println(invoke);//null
    }

    /*
    如何操作运行时类中指定的构造器 ---需要掌握
     */
     @Test
    public void testConstructor() throws Exception
   {
       Class clazz = Person.class;

       //private Person(String name)
       /*
       1.获取指定的构造器
       getDeclaredConstructor():参数：指明构造器的参列表
        */
       Constructor constructor = clazz.getDeclaredConstructor(String.class);

       //2.保证当前方法时可访问的
       constructor.setAccessible(true);

       //3.调用此构造器创建运行时类的对象
       Person tom = (Person) constructor.newInstance("Tom");
       System.out.println(tom);//Person{name='Tom', age=0, id=0}
   }
}
