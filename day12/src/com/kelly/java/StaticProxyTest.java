package com.kelly.java;

/**
 * @author Kelly  Email yuexiaoyilalala@gmail.com
 * @version 1.0
 * @Description
 * @date 2021/3/14 14:15
 */
interface ClothFactory
{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory
{

    private ClothFactory factory;//用被代理类进行实例化

    public ProxyClothFactory(ClothFactory factory)
    {
        this.factory = factory;
    }
    @Override
    public void produceCloth()
    {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory
{

    @Override
    public void produceCloth()
    {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest
{
    public static void main(String[] args)
    {
        //创建被代理的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
