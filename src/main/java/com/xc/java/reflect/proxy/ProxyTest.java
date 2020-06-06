package com.xc.java.reflect.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: xc
 * @Date: 2020/6/5
 */
public class ProxyTest {
    /**
     * 动态代理 相对于 静态代理的好处
     * 当有很多个  (interface Job) 然后需要代理的功能是一样的 上下班打卡
     * 这样静态代理 就需要很多个代理类
     * 而动态代理 只需要一个自动打卡的处理类LogHandler , 和Job无关
     */

    @Test
    public void testProxy(){
        Job job = new Person("张三");
        InvocationHandler logHandler=new LogHandler<>(job);
        //参数  代理类加载器,被代理接口,调用处理器
        Job jobProxy = (Job)Proxy.newProxyInstance(Job.class.getClassLoader(),new Class<?>[]{Job.class},logHandler);
        jobProxy.work();
    }
}
