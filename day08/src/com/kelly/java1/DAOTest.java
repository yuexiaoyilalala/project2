package com.kelly.java1;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/9 13:36
 */
public class DAOTest
{
    @Test
    public void test1()
    {
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);

        StudentDAO dao1 = new StudentDAO();
        Student student = dao1.getIndex(1);
    }
}


