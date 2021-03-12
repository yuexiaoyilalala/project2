package com.kelly.exer1;

import java.util.List;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/2/10 15:53
 */
public class DAOTest
{
    public static void main(String[] args)
    {
        DAO<Object> dao = new DAO<>();

        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,24,"昆凌"));
        dao.save("1003",new User(1003,33,"蔡依林"));

        dao.update("1003",new User(1003,30,"方文山"));

        dao.delete("1002");

        List<Object> list = dao.list();
        list.forEach(System.out :: println);
    }
}


