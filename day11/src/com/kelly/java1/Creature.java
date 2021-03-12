package com.kelly.java1;

import java.io.Serializable;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/11 18:43
 */
public class Creature<T> implements Serializable
{
        private char gender;
        public double weight;

        private void breath()
        {
            System.out.println("生物呼吸");
        }

        public void eat()
        {
            System.out.println("生物吃东西");
        }
}











