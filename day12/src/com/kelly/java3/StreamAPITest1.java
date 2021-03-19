package com.kelly.java3;

import com.kelly.java2.Employee;
import com.kelly.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/17 16:16
 */
public class StreamAPITest1
{
    //1.筛选与切片
    @Test
    public void test1()
    {
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p)---接收Lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();

//        Predicate<Employee> p = new Predicate<Employee>()
//        {
//            @Override
//            public boolean test(Employee e)
//            {
//                return e.getSalary() > 7000;
//            }
//        };
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out :: println);
        /*
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
         */

        System.out.println("************************");

        //limit(n)---截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out :: println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1003, name='刘强东', age=33, salary=3000.82}
         */

        System.out.println("************************");

        //skip(n)---跳出元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，
        //则返回一个空流，与limit(n)互补
        list.stream().skip(3).forEach(System.out :: println);
        /*
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        Employee{id=1007, name='任正非', age=26, salary=4333.32}
        Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
         */

        System.out.println("************************");

        //distinct()---筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010,"中本聪",40,8000));
        list.add(new Employee(1010,"中本聪",40,8000));
        list.add(new Employee(1010,"中本聪",40,8000));
        list.add(new Employee(1010,"中本聪",40,8000));
        list.add(new Employee(1010,"中本聪",40,8000));

        list.stream().distinct().forEach(System.out :: println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        Employee{id=1007, name='任正非', age=26, salary=4333.32}
        Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
        Employee{id=1010, name='中本聪', age=40, salary=8000.0}
         */
    }

    @Test
    public void test2()
    {
        //map(Function f)---接收一个函数作为参数，
        //该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa","bb","cc","dd");
//        Function<String,String> func = new Function<String, String>()
//        {
//            @Override
//            public String apply(String str)
//            {
//                return str.toUpperCase();
//            }
//        };
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);
        /*
        AA
        BB
        CC
        DD
         */

        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
//        Function<Employee,String> func4 = new Function<Employee, String>()
//        {
//            @Override
//            public String apply(Employee e)
//            {
//                return e.getName();
//            }
//        };
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out :: println);
        /*
        比尔盖茨
        扎克伯格
         */
        System.out.println("*************************");
        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {s.forEach(System.out :: println);});
        /*
        a
        a
        b
        b
        c
        c
        d
        d
         */

        System.out.println("*************************");
        //flatMap(Function f)---接收一个函数作为参数，将流中的每个值都换成另一个流
        //然后把所有流连接成一个流
        Function<String,Stream> func = new Function<String,Stream>()
        {
            @Override
            public Stream apply(String str)
            {
                return StreamAPITest1.fromStringToStream(str);
            }
        };
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out :: println );
        /*
        a
        a
        b
        b
        c
        c
        d
        d
         */

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream实例
    public static Stream<Character> fromStringToStream(String str)
    {
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray())
        {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3()
    {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        //list1.add(list2);//[1, 2, 3, [4, 5, 6]]
        list1.addAll(list2);//[1, 2, 3, 4, 5, 6]
        System.out.println(list1);
    }

    //排序
    @Test
    public void test4()
    {
        //sorted()---自然排序
        List<Integer> list = Arrays.asList(12, 45, 34, 76, 87, -6);
        list.stream().sorted().forEach(System.out :: println);
        /*
        -6
        12
        34
        45
        76
        87
         */

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out :: println);

        //sorted(Comparator com)---定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) ->
        {
            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue != 0)
            {
                return ageValue;
            }
            else
            {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out :: println);
        /*
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1007, name='任正非', age=26, salary=4333.32}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
         */
    }
}



