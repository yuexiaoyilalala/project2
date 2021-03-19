package com.kelly.java3;

import com.kelly.java2.Employee;
import com.kelly.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/19 12:31
 */
public class StreamAPITest2
{
    //1.匹配与查找
    @Test
    public void test1()
    {
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)---检查是否匹配所有元素。
        // 练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);//false

        //anyMatch(Predicate p)---检查是否至少匹配一个元素。
        //练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);//false

        //noneMatch(Predicate p)---检查是否没有匹配的元素
        //练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().anyMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);//true

        //findFirst---返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);//Optional[Employee{id=1001, name='马化腾', age=34, salary=6000.38}]

        //findAny---返回当前流中的任意元素
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);//Optional[Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}]
    }

    @Test
    public void test2()
    {
        //count---返回流中元素的总个数
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);//5

        //max(Comparator c)---返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);//Optional[9876.12]

        //min(Comparator c)---返回流中最小值
        //练习：返回工资最低的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);//Optional[Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}]

        //forEach(Consumer c)---内部迭代
        employees.stream().forEach(System.out::println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        Employee{id=1007, name='任正非', age=26, salary=4333.32}
        Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
         */

        //使用集合的遍历操作
        employees.forEach(System.out::println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1003, name='刘强东', age=33, salary=3000.82}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1005, name='李彦宏', age=65, salary=5555.32}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
        Employee{id=1007, name='任正非', age=26, salary=4333.32}
        Employee{id=1008, name='扎克伯格', age=35, salary=2500.32}
         */
    }

    //2.归约
    @Test
    public void test3()
    {
        //reduce(T identity,BinaryOperator)---可以将流中元素反复结合起来，得到一个值，返回一个T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>()
//        {
//            @Override
//            public Integer apply(Integer int1, Integer int2)
//            {
//                return Integer.sum(int1,int2);
//            }
//        };
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);//55

        //reduce(BinaryOperator)---可以将流中元素反复结合起来，得到一个值，
        //返回Optional<T>
        //练习：计算公式所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumMoney = salaryStream.reduce(Double::sum);
        //Optional<Double> sumMoney = salaryStream.reduce((d1,d2) -> d1 + d2);//Optional[48424.08]
        System.out.println(sumMoney);//Optional[48424.08]
    }

    //3.收集
    @Test
    public void test4()
    {
        //collect(Collector c)---将流转化为其他形式，接收一个Collector接口的实现，
        //用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回一个为List和Set
        List<Employee> employees = EmployeeData.getEmployees();

        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out :: println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
         */

        System.out.println("******************************");

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out :: println);
        /*
        Employee{id=1001, name='马化腾', age=34, salary=6000.38}
        Employee{id=1002, name='马云', age=12, salary=9876.12}
        Employee{id=1004, name='雷军', age=26, salary=7657.37}
        Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}
         */
    }
}


